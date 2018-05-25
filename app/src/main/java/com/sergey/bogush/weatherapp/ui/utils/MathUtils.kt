package com.sergey.bogush.weatherapp.ui.utils

import android.graphics.Point

/**
 * Created by Sergey on 5/25/2018.
 */

object MathUtils {

    var FILTER_FACTOR = 0.5f

    fun filter_0_2PI(new_val: Float, acc_val: Float): Float {
        var new_val = new_val
        var acc_val = acc_val

        if (Math.abs(new_val - acc_val) > TrigMath.PI) {

            //there is a step, adjust new value
            if (new_val < acc_val)
                new_val += TrigMath.TWO_PI
            else
                new_val -= TrigMath.TWO_PI
        }

        acc_val = new_val * FILTER_FACTOR + acc_val * (1f - FILTER_FACTOR)

        return MathUtils.norm_0_2PI(acc_val)
    }

    fun filter_MPI_PI(new_val: Float, acc_val: Float): Float {
        var new_val = new_val
        var acc_val = acc_val

        if (Math.abs(new_val - acc_val) > TrigMath.PI) {

            //there is a step, adjust new value
            if (new_val < acc_val)
                new_val += TrigMath.TWO_PI
            else
                new_val -= TrigMath.TWO_PI
        }

        acc_val = new_val * FILTER_FACTOR + acc_val * (1.0f - FILTER_FACTOR)

        return MathUtils.norm_MPI_PI(acc_val)
    }

    fun norm_0_2PI(a: Float): Float {

        if (a > TrigMath.TWO_PI)
            return a - TrigMath.TWO_PI
        return if (a < 0) a + TrigMath.TWO_PI else a
    }

    fun norm_MPI_PI(a: Float): Float {

        if (a > TrigMath.PI)
            return a - TrigMath.TWO_PI
        return if (a < -TrigMath.PI) a + TrigMath.TWO_PI else a
    }

    fun norm_0_360(a: Float): Float {

        if (a > 360)
            return a - 360
        return if (a < 0) a + 360 else a
    }

    fun norm_0_360(a: Int): Int {

        if (a > 360)
            return a - 360
        return if (a < 0) a + 360 else a
    }

    fun clamp_m90_90(a: Double): Double {
        if (a < -90.0)
            return -90.0
        return if (a > 90.0) 90.0 else a
    }

    fun norm_m180_180(a: Double): Double {
        if (a < -180.0)
            return a + 360.0
        return if (a > 180.0) a - 360.0 else a
    }

    fun sqr(x: Double): Double {
        return x * x
    }

    fun dist(p1: Point, p2: Point): Double {
        return Math.sqrt(sqr((p2.x - p1.x).toDouble()) + sqr((p2.y - p1.y).toDouble()))
    }
}
