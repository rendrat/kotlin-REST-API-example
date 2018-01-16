package org.rendra.driver.verticle

import id.yoframework.core.extension.logger.logger
import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import org.rendra.driver.consumer.DriverConsumer
import javax.inject.Inject
import javax.inject.Singleton

/**
 * WorkerVerticle, will not managed by Event-Loop Thread
 * It's Responsible for consumers initialization
 *
 * @author Rendra Toro
 */

@Singleton
class WorkerVerticle @Inject constructor(private val driverConsumer: DriverConsumer) : AbstractVerticle() {
    val log = logger(WorkerVerticle::class)

    override fun start(startFuture: Future<Void>) {
        log.info("Initialize Worker Verticle")
        driverConsumer()
        startFuture.complete()
    }
}