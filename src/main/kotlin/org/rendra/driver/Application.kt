package org.rendra.driver

import id.yoframework.core.extension.config.propertiesConfig
import id.yoframework.core.extension.config.retrieveConfig
import id.yoframework.core.extension.logger.logger
import id.yoframework.core.extension.logger.useLogback
import id.yoframework.core.extension.vertx.buildVertx
import id.yoframework.core.extension.vertx.deployVerticle
import id.yoframework.core.module.CoreModule
import kotlinx.coroutines.experimental.runBlocking
import org.rendra.driver.module.DaggerAppComponent
import org.rendra.driver.module.MongoModule


/**
 * Main Class is using :
 * - Vertx to request and response Handler
 * - Hazelcast to Manage Cluster that allow several instance of vertx application communicate each other
 * - Dagger for Dependency Injection
 *
 * @author Rendra Toro
 */

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) = runBlocking<Unit> {
            useLogback()
            val log = logger(org.rendra.driver.Application::class)

            val vertx = buildVertx()
            val properties = propertiesConfig("application-config.properties")
            val config = vertx.retrieveConfig(properties)

            log.info("Initiate Components...")
            val app = try {
                DaggerAppComponent.builder()
                        .coreModule(CoreModule(config, vertx))
                        .mongoModule(MongoModule())
                        .build()
            } catch (e: Exception) {
                System.exit(1)
                throw e
            }


            log.info("Execute Data Initializer")
            val dataInitializer = app.dataInitializer()
            dataInitializer()

            val workerOnly = config.getBoolean("WORKER_ONLY", false)
            if (!workerOnly
                    ) {
                log.info("Deploying Main Verticle")
                val mainVerticle = app.mainVerticle()
                vertx.deployVerticle(mainVerticle, config)
            }

            val apiOnly = config.getBoolean("API_ONLY", false)
            if (!apiOnly
                    ) {
                log.info("Deploying Worker Verticle")
                val workerVerticle = app.workerVerticle()
                vertx.deployVerticle(workerVerticle, config, true)
            }
        }
    }
}
