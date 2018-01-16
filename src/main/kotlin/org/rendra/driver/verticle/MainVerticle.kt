package org.rendra.driver.verticle

import id.yoframework.core.extension.logger.logger
import id.yoframework.web.extension.startHttpServer
import io.vertx.kotlin.coroutines.CoroutineVerticle
import org.rendra.driver.controller.MainController
import javax.inject.Inject
import javax.inject.Singleton

/**
 * MainVerticle handles HttpServer.
 *
 * @author Rendra Toro.
 */

@Singleton
class MainVerticle @Inject constructor(private val mainController: MainController) : CoroutineVerticle() {
    private val log = logger(MainVerticle::class)

    override suspend fun start() {
        log.info("Starting HttpServer...")
        try {
            val httpServer = vertx.startHttpServer(mainController.create(), config.getInteger("HTTP_PORT"))
            log.info("HttpServer started in port ${httpServer.actualPort()}")
            log.info("Main Verticle Deployed!")
        } catch (e: Exception) {
            log.error("Failed to start HttpServer. [${e.message}]", e)
            log.error("Main Verticle Failed to Deploy!")
        }
    }
}