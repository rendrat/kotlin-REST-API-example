package org.rendra.driver.value

import org.rendra.driver.extension.toRadian
import org.rendra.driver.type.Degree
import org.rendra.driver.type.Radian

/**
 * [Documentation Here]
 *
 * @author Rendra Toro
 */

data class GeoLocation(private val latitude: Degree, val longitude: Degree) {
    val radlatitude: Radian = latitude.toRadian()
    val radLongitude: Radian = longitude.toRadian()
}