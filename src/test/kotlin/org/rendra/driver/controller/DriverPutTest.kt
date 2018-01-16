package org.rendra.driver.controller

import id.yoframework.core.extension.config.propertiesConfig
import id.yoframework.core.extension.config.retrieveConfig
import id.yoframework.core.extension.logger.logger
import id.yoframework.core.extension.resource.randomPort
import id.yoframework.core.extension.vertx.buildVertx
import id.yoframework.core.extension.vertx.deployVerticle
import id.yoframework.core.module.CoreModule
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.ext.unit.TestContext
import io.vertx.ext.unit.junit.RepeatRule
import io.vertx.ext.unit.junit.VertxUnitRunner
import io.vertx.ext.web.client.WebClient
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj
import kotlinx.coroutines.experimental.runBlocking
import org.rendra.driver.extension.randomDouble
import org.rendra.driver.extension.randomInt
import org.rendra.driver.model.Area
import org.rendra.driver.module.DaggerTestAppComponent
import org.rendra.driver.module.MongoModule
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.test.assertTrue

/**
 * Test class for PUT /drivers/:id/location
 *
 * @author Rendra Toro
 */
@RunWith(VertxUnitRunner::class)
class DriverPutTest {

    companion object {
        val log = logger(DriverPutTest::class)

        lateinit var vertx: Vertx
        lateinit var sharedConfig: JsonObject
        var port: Int = 0

        /**
         * Setup vertx
         * - Find unused port
         * - Retrieve config from properties files
         * - Initialize Dagger Objects
         * - Deploy Main Verticle that run HttpServer on previously defined port
         * - Deploy Worker Verticle that consume message from EventBus
         *
         */
        @BeforeClass
        @JvmStatic
        fun setUp(context: TestContext) = runBlocking<Unit> {
            log.info("Initialize Components")


            port = randomPort()
            vertx = buildVertx()
            val properties = propertiesConfig("application-config-test.properties")
            val config = vertx.retrieveConfig(properties).apply {
                put("HTTP_PORT", port)
            }
            sharedConfig = config
            val app = org.rendra.driver.module.DaggerTestAppComponent.builder()
                    .coreModule(CoreModule(config, vertx))
                    .mongoModule(MongoModule())
                    .build()

            val initializer = app.initializer()
            initializer()

            vertx.deployVerticle(app.mainVerticle(), config, false)
            vertx.deployVerticle(app.workerVerticle(), config, true)
            assertTrue(true, "Initialize Components Success")
        }


        /**
         * Destroy Vertx including its Verticles to free up resources such as port and database connections
         */
        @AfterClass
        @JvmStatic
        fun tearDown(context: TestContext) {
            log.info("Destroy Vertx.......")
            vertx.close(context.asyncAssertSuccess())
        }
    }


    @Rule
    @JvmField
    var rule = RepeatRule()

    /**
     * Test for PUT  /drivers/:id/location
     * - Latitude and Longitude selected randomly inside Bogor area
     * - Due to Architecture nature that Controller only handles validation and send request to Worker Verticle that works asynchronously
     *   This test will failed if we repeat it several times. It caused by error that occurred when Vertx already taken down by @AfterClass method
     *   but Worker still processing the request
     * - For producing seed data, we can enable @Repeat flag but ignore test failed
     *
     * Note: First request will takes more time than next tests.
     * In my Machine first request takes up to 100ms but next test only takes 0-2ms
     */
//    @Repeat(100)
    @Test
    fun driverPutLocationTest(context: TestContext) {
        val async = context.async()
        val port = sharedConfig.getInteger("HTTP_PORT")
        val bogor = Area(code = "BGR", name = "Bogor", minLatitude = -6.8521162, maxLatitude = -6.737798, minLongitude = 106.299794, maxLongitude = 106.458480)
        val client = WebClient.create(vertx)

        val driverId = randomInt(1, 50_000)
        val latitude = randomDouble(bogor.minLatitude, bogor.maxLatitude)
        val longitude = randomDouble(bogor.minLongitude, bogor.maxLongitude)

        val requestBody = json {
            obj(
                    "latitude" to latitude,
                    "longitude" to longitude,
                    "accuracy" to 0.8
            )
        }

        val timeNow = System.currentTimeMillis()

        log.info("Request PUT to localhost:$port/drivers/$driverId/location")
        log.info("Send PUT body ${requestBody.encode()}")

        client.put(port, "localhost", "/drivers/$driverId/location")
                .sendJsonObject(requestBody) { asyncResult ->
                    context.assertTrue(asyncResult.succeeded())
                    val response = asyncResult.result()
                    log.info("Response Body ${response.bodyAsString()}")
                    context.assertEquals(response.statusCode(), 200)
                    val timeTaken = System.currentTimeMillis() - timeNow
                    log.info("PUT Driver Location takes $timeTaken ms")
                    async.complete()
                }
    }

}