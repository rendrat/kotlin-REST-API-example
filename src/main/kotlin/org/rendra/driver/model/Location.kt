package org.rendra.driver.model

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import org.bson.types.ObjectId
import org.rendra.driver.type.Degree
import org.mongodb.morphia.annotations.Embedded
import org.mongodb.morphia.annotations.Entity
import org.mongodb.morphia.annotations.Field
import org.mongodb.morphia.annotations.Id
import org.mongodb.morphia.annotations.Index
import org.mongodb.morphia.annotations.IndexOptions
import org.mongodb.morphia.annotations.Indexed
import org.mongodb.morphia.annotations.Indexes
import org.mongodb.morphia.utils.IndexDirection
import java.time.LocalDateTime

/**
 * This Model Represents Driver Current Location
 * Driver should send their location every 60 seconds
 *
 * @author Rendra Toro
 */

@Entity("location")
@Indexes(
    Index(value = "driver_id_idx", fields = arrayOf(Field("driverId")), options = IndexOptions(unique = true))
)
class Location() {
    constructor(
        id: ObjectId? = null,
        driverId: Int,
        areaCode: String,
        latitude: Degree,
        longitude: Degree,
        accuracy: Double,
        lastUpdated: LocalDateTime
    ) : this() {
        this.id = id
        this.driverId = driverId
        this.areaCode = areaCode
        this.point = Point(longitude = longitude, latitude = latitude)
        this.accuracy = accuracy
        this.lastUpdated = lastUpdated
    }

    @Id
    @JsonSerialize(using = ToStringSerializer::class)
    var id: ObjectId? = null
    var driverId: Int = -1
    lateinit var areaCode: String
    @Indexed(IndexDirection.GEO2DSPHERE)
    lateinit var point: Point
    var accuracy: Double = 0.0
    @JsonSerialize(using = ToStringSerializer::class)
    lateinit var lastUpdated: LocalDateTime
}

@Embedded
class Point() {
    constructor(
        type: String = "Point",
        latitude: Degree,
        longitude: Degree
    ) : this() {
        this.type = type
        this.coordinates = arrayOf(longitude, latitude)
    }

    var type: String = "Point"
    lateinit var coordinates: Array<Double>
}

