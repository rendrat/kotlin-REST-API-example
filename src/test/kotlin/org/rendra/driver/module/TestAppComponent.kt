package org.rendra.driver.module

import dagger.Component
import id.yoframework.core.module.CoreModule
import id.yoframework.web.module.WebModule
import org.rendra.driver.type.UnitCallable
import org.rendra.driver.verticle.MainVerticle
import org.rendra.driver.verticle.WorkerVerticle
import org.mongodb.morphia.Datastore
import javax.inject.Named
import javax.inject.Singleton

/**
 * Dagger Component exclusive for Test
 *
 * @author Rendra Toro
 */

@Singleton
@Component(modules = [CoreModule::class, WebModule::class, MongoModule::class])
interface TestAppComponent {
    fun mainVerticle(): MainVerticle
    fun workerVerticle(): WorkerVerticle
    fun datastore(): Datastore
    @Named("dataInitializer")
    fun initializer(): UnitCallable
}