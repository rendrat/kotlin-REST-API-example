package org.rendra.driver.module

import com.mongodb.DBObject
import com.mongodb.MongoClient
import com.mongodb.util.JSON
import dagger.Module
import dagger.Provides
import id.yoframework.core.extension.logger.logger
import id.yoframework.morphia.extension.buildMorphiaDatastore
import id.yoframework.morphia.extension.count
import id.yoframework.morphia.module.MorphiaModule
import org.rendra.driver.model.Area
import org.rendra.driver.type.UnitCallable
import org.mongodb.morphia.Datastore
import javax.inject.Named
import javax.inject.Singleton


/**
 * MongoModule used to initialize MongoDB connection and Morphia
 *
 * @author Rendra Toro.
 */

@Module(includes = [MorphiaModule::class])
class MongoModule {
    private val log = logger<MongoModule>()

    @Provides
    @Singleton
    fun datastore(client: MongoClient,
                  @Named("morphiaDatabaseName") databaseName: String): Datastore {
        return client.buildMorphiaDatastore(databaseName, setOf("org.rendra.driver.model"))
    }

    @Provides
    @Singleton
    @Named("dataInitializer")
    fun provideInitializer(datastore: Datastore): UnitCallable {
        return {
            if (datastore.count<Area>() == 0L) {
                val bogor = Area(code = "BGR", name = "Bogor", minLatitude = -6.8521162, maxLatitude = -6.737798, minLongitude = 106.299794, maxLongitude = 106.458480)
                datastore.save(bogor)
                log.info("Area ${bogor.name} Saved")
            }
        }
    }

}