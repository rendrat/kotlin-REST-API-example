package org.rendra.driver.model

import org.rendra.driver.type.Degree
import org.mongodb.morphia.annotations.Entity
import org.mongodb.morphia.annotations.Id

/**
 * Model that Represents Area (City)
 *
 * @author Rendra Toro
 */

@Entity("area")
class Area() {
    constructor(
        code: String,
        name: String,
        minLatitude: Degree,
        maxLatitude: Degree,
        minLongitude: Degree,
        maxLongitude: Degree
    ) : this() {
        this.code = code
        this.name = name
        this.minLatitude = minLatitude
        this.maxLatitude = maxLatitude
        this.minLongitude = minLongitude
        this.maxLongitude = maxLongitude
    }

    @Id
    lateinit var code: String
    lateinit var name: String
    var minLatitude: Degree = 0.0
    var maxLatitude: Degree = 0.0
    var minLongitude: Degree = 0.0
    var maxLongitude: Degree = 0.0

    fun isInside(latitude: Degree, longitude: Degree): Boolean {
        if (latitude < minLatitude && latitude > maxLatitude) {
            return false
        }

        if (longitude < minLongitude && longitude > maxLongitude) {
            return false
        }

        return true
    }
}