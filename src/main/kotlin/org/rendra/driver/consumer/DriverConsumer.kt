package org.rendra.driver.consumer


import org.rendra.driver.extension.round
import org.rendra.driver.model.Location
import org.rendra.driver.model.Point
import id.yoframework.core.extension.logger.logger
import id.yoframework.morphia.extension.createQuery
import id.yoframework.morphia.extension.createUpdateOperations
import io.vertx.core.eventbus.EventBus
import io.vertx.core.json.JsonObject
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import org.mongodb.morphia.Datastore
import org.mongodb.morphia.query.Query
import org.mongodb.morphia.query.UpdateOperations
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Event Bus Consumer. This will handles driver related event
 *
 * @author Rendra Toro
 */

@Singleton
class DriverConsumer @Inject constructor(val eventBus: EventBus,
                                         val datastore: Datastore) {
    val log = logger(DriverConsumer::class)

    operator fun invoke() = runBlocking<Unit> {
        log.info("Register consumer for [driver.put.location]")
        eventBus.consumer<JsonObject>("driver.put.location") { message ->

            val request: JsonObject = message.body() ?: JsonObject()
            var driverId: Int = 0
            var latitude: Double = 0.0
            var longitude: Double = 0.0
            var accuracy: Double = 0.0
            var query: Query<Location>? = null
            var updateOperation: UpdateOperations<Location>? = null

            val createRequestBody = async(CommonPool) {
                driverId = message.headers().get("driverId").toIntOrNull() ?: throw IllegalArgumentException("Header driverId is missing!")

                log.info("Process [driver.put.location] with driverId[$driverId]  and Body [${request.encode()}]")
                latitude = request.getDouble("latitude") ?: throw IllegalArgumentException("Body latitude is missing")
                longitude = request.getDouble("longitude") ?: throw IllegalArgumentException("Body longitude is missing")
                accuracy = request.getDouble("accuracy") ?: throw IllegalArgumentException("Body Accuracy is Missing")
            }

            val createQueryFilter = async(CommonPool) {
                query = datastore.createQuery<Location>()
                        .filter("driverId", driverId)
            }

            val mappingData = async(CommonPool) {

                updateOperation = datastore.createUpdateOperations<Location>()
                        .set("point", Point(latitude = latitude.round(6), longitude = longitude.round(6)))
                        .set("accuracy", accuracy.round(1))
                        .set("driverId", driverId)
                        .set("areaCode", "BGR")
                        .set("lastUpdated", LocalDateTime.now())

            }

            val insertIntoDatabase = async(CommonPool) {
                datastore.update(query, updateOperation, true)
            }


            launch(CommonPool) {
                createRequestBody.await()
                createQueryFilter.await()
                createQueryFilter.await()
                mappingData.await()
                insertIntoDatabase.await()
            }

        }
    }
}