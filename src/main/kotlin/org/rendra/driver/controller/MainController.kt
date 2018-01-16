package org.rendra.driver.controller

import id.yoframework.core.extension.json.getDouble
import id.yoframework.core.extension.logger.logger
import id.yoframework.morphia.extension.createQuery
import id.yoframework.morphia.extension.getById
import id.yoframework.web.controller.Controller
import id.yoframework.web.extension.OK
import id.yoframework.web.extension.jsonBody
import id.yoframework.web.extension.param
import io.vertx.core.eventbus.DeliveryOptions
import io.vertx.core.eventbus.EventBus
import io.vertx.core.json.Json
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import org.rendra.driver.extension.badRequest
import org.rendra.driver.extension.notFound
import org.rendra.driver.extension.unprocessableEntity
import org.rendra.driver.model.Area
import org.rendra.driver.model.Location
import org.mongodb.morphia.Datastore
import org.mongodb.morphia.geo.GeoJson
import org.mongodb.morphia.geo.Point
import org.mongodb.morphia.query.FindOptions
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Main Controller that contains Handler for API request /drivers and /drivers/:id/location endpoint
 *
 * @author Rendra Toro.
 */

@Singleton
class MainController @Inject constructor(override val router: Router,
                                         val datastore: Datastore,
                                         val eventBus: EventBus) : Controller({

    val log = logger(MainController::class)
    /**
     * This API will only server for Bogor Area
     * Data will be loaded from MongoDB, if data did not exists, controller will failed to start.
     * This is using Kotlin Lazy memoization, so data will only loaded once
     */
    val bogor =
            datastore.getById<Area>("BGR") ?: throw Exception("Bogor Area is Not Found!")

    route().last().handler { it.fail(404) }

    route().handler(BodyHandler.create())

    get("/drivers").handler(fun(context) {
        val latitude = context.param("latitude")?.toDoubleOrNull()
        val longitude = context.param("longitude")?.toDoubleOrNull()
        val radius = context.param("radius")?.toIntOrNull() ?: 500
        val limit = context.param("limit")?.toIntOrNull() ?: 10

        if (latitude == null || longitude == null) {
            context.badRequest("Latitude or longitude cannot be empty")
            return
        }

        if (latitude < -90 || latitude > 90) {
            context.badRequest("Latitude should between -/+ 90")
            return
        }

        if (longitude < -180 || longitude > 180) {
            context.badRequest("Longitude should between -/+ 180")
            return
        }

        var point: Point? = null
        var result: List<Location> = ArrayList<Location>();

        val createPointQuery = async(CommonPool) {
            point = GeoJson.point(latitude, longitude)
        }

        val getDataFromDatabase = async(CommonPool) {
            result = datastore.createQuery<Location>()
                    .field("point").near(point, radius)
                    .asList(FindOptions().limit(limit))
        }

        val sendResponse = async(CommonPool) {
            context.OK(Json.encode(result))
        }

        launch(CommonPool) {
            createPointQuery.await()
            getDataFromDatabase.await()
            sendResponse.await()
        }

    })

    /**
     * Handles Driver location PUT
     *
     * - Id must be Integer Type
     * - Id value must be between 1 to 50000
     * - For now only Bogor Area is Supported (this is for Proof of Concept)
     * - Submitted location must be inside Bogor Area, according to their minimum and maximum Latitude and Longitude
     * - Location Accuracy must greater than or equals to  0.7
     *
     * This Controller mainly check as validation, after all success data will be send to Worker Verticle through EventBus.
     *
     * Note: This Controller Handler use anonymous function instead of Lambda.
     * So it will produce multiple return that unsupported in lambda notation for more readable code especially when validating.
     */
    put("/drivers/:id/location").consumes("*/json").handler(fun(context) {
        val id: Int? = context.pathParam("id")?.toIntOrNull()
        if (id == null || id !in 1..50000) {
            context.notFound()
            return
        }

        val body = context.jsonBody()
        if (body == null) {
            context.unprocessableEntity("Request Body is empty or malformed JSON")
            return
        }

        val accuracy = body.getDouble("accuracy")
        if (accuracy == null || accuracy < 0.7) {
            context.unprocessableEntity("Accuracy cannot empty or less than 0.7")
            return
        }

        val latitude = body.getDouble("latitude")
        val longitude = body.getDouble("longitude")
        if (latitude == null || longitude == null) {
            context.unprocessableEntity("Latitude or longitude cannot be empty")
            return
        }

        if (latitude < -90 || latitude > 90) {
            context.unprocessableEntity("Latitude should between -/+ 90")
            return
        }

        if (longitude < -180 || longitude > 180) {
            context.unprocessableEntity("Longitude should between -/+ 180")
            return
        }

        if (!bogor.isInside(latitude, longitude)) {
            context.unprocessableEntity("Location should inside latitude[${bogor.minLatitude} to ${bogor.maxLatitude}]" +
                    " and longitude[${bogor.minLongitude} to ${bogor.maxLongitude}]")
            return
        }

        log.info("Send [driver.put.location] with driverId[$id] and body[${body.encode()}]")
        eventBus.send("driver.put.location", body, DeliveryOptions().apply { addHeader("driverId", id.toString()) })

        context.OK("{}")
        return
    })


})