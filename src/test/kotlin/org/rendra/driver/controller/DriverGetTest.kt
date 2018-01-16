package org.rendra.driver.controller

import id.yoframework.core.extension.config.propertiesConfig
import id.yoframework.core.extension.config.retrieveConfig
import id.yoframework.core.extension.logger.logger
import id.yoframework.core.extension.resource.randomPort
import id.yoframework.core.extension.vertx.buildVertx
import id.yoframework.core.extension.vertx.deployVerticle
import id.yoframework.core.module.CoreModule
import io.vertx.core.DeploymentOptions
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.ext.unit.TestContext
import io.vertx.ext.unit.junit.Repeat
import io.vertx.ext.unit.junit.RepeatRule
import io.vertx.ext.unit.junit.VertxUnitRunner
import io.vertx.ext.web.client.WebClient
import kotlinx.coroutines.experimental.runBlocking
import org.rendra.driver.extension.randomDouble
import org.rendra.driver.extension.round
import org.rendra.driver.model.Area
import org.rendra.driver.module.DaggerTestAppComponent
import org.rendra.driver.module.MongoModule
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.net.ServerSocket
import kotlin.test.assertTrue

/**
 * Test Class for get /drivers
 *
 * @author Rendra Toro
 */
@RunWith(VertxUnitRunner::class)
class DriverGetTest {
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
        fun setUp(context: TestContext)= runBlocking<Unit> {
            log.info("Initialize Components")

            port = randomPort()
            vertx = buildVertx()
            val properties = propertiesConfig("application-config-test.properties")
            val config = vertx.retrieveConfig(properties).apply {
                put("HTTP_PORT",port)
            }
            sharedConfig = config
            val app = org.rendra.driver.module.DaggerTestAppComponent.builder()
                    .coreModule(CoreModule(config, DriverPutTest.vertx))
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
     * Test for GET /drivers
     * - Latitude and Longitude selected randomly
     * - This test can be repeated as needed
     *
     * Note: First request will takes more time than next tests.
     * In my Machine first request takes up to 400ms but next test only takes 3-5ms
     */
    @Repeat(100)
    @Test
    fun driverGetTest(context: TestContext) {
        val async = context.async()
        val port = sharedConfig.getInteger("HTTP_PORT")
        val bogor = Area(code = "BGR", name = "Bogor", minLatitude = -6.8521162, maxLatitude = -6.737798, minLongitude = 106.299794, maxLongitude = 106.458480)

        val latitude = randomDouble(bogor.minLatitude, bogor.maxLatitude).round(6)
        val longitude = randomDouble(bogor.minLongitude, bogor.maxLongitude).round(6)

        val client = WebClient.create(vertx)
        val timeNow = System.currentTimeMillis()

        log.info("Request GET to localhost:$port/drivers")

        client.get(port, "localhost", "/drivers")
                .addQueryParam("latitude", latitude.toString())
                .addQueryParam("longitude", longitude.toString())
                .addQueryParam("radius", "5000")
                .addQueryParam("limit", "20")
                .send { asyncResult ->
                    if (asyncResult.failed()) {
                        log.error("${asyncResult.cause().message} when get", asyncResult.cause())
                    }
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