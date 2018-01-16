package org.rendra.driver.extension

import org.rendra.driver.type.Degree
import org.rendra.driver.type.Kilometer
import org.rendra.driver.type.Meter
import org.rendra.driver.type.Mile
import org.rendra.driver.type.Radian
import org.rendra.driver.value.GeoLocation

/**
 * [Documentation Here]
 *
 * @author Rendra Toro
 */

fun Degree.toRadian(): Radian {
    return Math.toRadians(this)
}

fun Radian.toDegree(): Degree {
    return Math.toDegrees(this)
}


fun Mile.toKilometer(): Kilometer {
    return this * 1.609344
}

fun Kilometer.toMile(): Mile {
    return this * 0.621371192
}

fun Mile.toMeter(): Meter {
    return this.toKilometer() * 1000
}

fun Double.toString(round: Int): String {
    return if (round < 1) {
        this.toString()
    } else {
        String.format("%.${round}f", this)
    }
}

fun Double.round(round: Int): Double {
    val stringFormat = this.toString(round)
    return stringFormat.toDouble()
}

infix fun GeoLocation.distanceTo(destination: GeoLocation): Meter {
    val theta: Degree = this.longitude - destination.longitude
    val thetaRad: Radian = theta.toRadian()
    val distance: Radian = Math.acos(
        Math.sin(this.radlatitude) * Math.sin(destination.radlatitude) +
            Math.cos(this.radlatitude) * Math.cos(destination.radlatitude) * Math.cos(thetaRad)
    )
    val distanceDegree: Degree = distance.toDegree()
    val distanceMiles: Mile = distanceDegree * 60 * 1.1515
    return distanceMiles.toMeter()
}