package org.rendra.driver.extension

import java.util.concurrent.ThreadLocalRandom

/**
 * [Documentation Here]
 *
 * @author Rendra Toro
 */

fun randomDouble(origin: Double, bound: Double): Double {
    return ThreadLocalRandom.current().nextDouble(origin, bound)
}

fun randomInt(origin: Int, bound: Int): Int {
    return ThreadLocalRandom.current().nextInt(origin, bound)
}
