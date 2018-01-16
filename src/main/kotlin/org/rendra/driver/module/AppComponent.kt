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
 * Dagger Component to Expose Required Object(s)
 *
 * @author Rendra Toro
 */

@Singleton
@Component(modules = [CoreModule::class, WebModule::class, MongoModule::class])
interface AppComponent {
    fun dataStore(): Datastore
    fun mainVerticle(): MainVerticle
    fun workerVerticle(): WorkerVerticle

    @Named("dataInitializer")
    fun dataInitializer(): UnitCallable
}