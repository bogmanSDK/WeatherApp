package com.sergey.bogush.weatherapp.ui.utils

import android.util.Log

/**
 * Created by Sergey on 5/25/2018.
 */

object TrigMath {
    private val TAG = "TrigMath"

    val PI = Math.PI.toFloat()

    val TWO_PI = 2 * PI

    val HALF_PI = PI / 2

    private val ATAN2_BITS = 7

    private val ATAN2_BITS2 = ATAN2_BITS shl 1

    private val ATAN2_MASK = (-1 shl ATAN2_BITS2).inv()

    private val ATAN2_COUNT = ATAN2_MASK + 1

    private val ATAN2_DIM = Math.sqrt(ATAN2_COUNT.toDouble()).toInt()

    private val ATAN2_DIM_MINUS_1 = (ATAN2_DIM - 1).toFloat()

    private val atan2 = FloatArray(ATAN2_COUNT)

    private val SIN_BITS: Int
    private val SIN_MASK: Int
    private val SIN_COUNT: Int

    private val radFull: Float
    private val radToIndex: Float

    private val sin: FloatArray
    private val cos: FloatArray

    init {
        Log.d(TAG, "Start init")

        for (i in 0 until ATAN2_DIM) {
            for (j in 0 until ATAN2_DIM) {
                val x0 = i.toFloat() / ATAN2_DIM
                val y0 = j.toFloat() / ATAN2_DIM

                atan2[j * ATAN2_DIM + i] = Math.atan2(y0.toDouble(), x0.toDouble()).toFloat()
            }
        }

        SIN_BITS = 12
        SIN_MASK = (-1 shl SIN_BITS).inv()
        SIN_COUNT = SIN_MASK + 1

        radFull = (Math.PI * 2.0).toFloat()
        radToIndex = SIN_COUNT / radFull

        sin = FloatArray(SIN_COUNT)
        cos = FloatArray(SIN_COUNT)

        for (i in 0 until SIN_COUNT) {
            sin[i] = Math.sin(((i + 0.5f) / SIN_COUNT * radFull).toDouble()).toFloat()
            cos[i] = Math.cos(((i + 0.5f) / SIN_COUNT * radFull).toDouble()).toFloat()
        }

        Log.d(TAG, "End init")
    }

    /**
     * Like [Math.sin], but a lot faster and a bit less
     * accurate
     *
     * @param rad
     * @return sin(rad)
     */
    fun sin(rad: Float): Float {
        return sin[(rad * radToIndex).toInt() and SIN_MASK]
    }

    /**
     * Like [Math.cos], but a lot faster and a bit less
     * accurate
     *
     * @param rad
     * @return cos(rad)
     */
    fun cos(rad: Float): Float {
        return cos[(rad * radToIndex).toInt() and SIN_MASK]
    }

    fun tan(rad: Float): Float {

        return sin(rad) / cos(rad)
    }

    /**
     * @param y
     * @param x
     * @return the angle to (x,y)
     */
    fun atan2(y: Float, x: Float): Float {
        var y = y
        var x = x
        val add: Float
        val mul: Float

        if (x < 0.0f) {
            if (y < 0.0f) {
                x = -x
                y = -y

                mul = 1.0f
            } else {
                x = -x
                mul = -1.0f
            }

            add = -3.141592653f
        } else {
            if (y < 0.0f) {
                y = -y
                mul = -1.0f
            } else {
                mul = 1.0f
            }

            add = 0.0f
        }

        val invDiv = ATAN2_DIM_MINUS_1 / if (x < y) y else x

        val xi = (x * invDiv).toInt()
        val yi = (y * invDiv).toInt()

        return (atan2[yi * ATAN2_DIM + xi] + add) * mul
    }

    /**
     * @param degrees
     * @return the radians value
     */
    fun toRadians(degrees: Float): Float {
        return degrees / 180.0f * PI
    }

    /**
     * @param radians
     * @return the degrees value
     */
    fun toDegrees(radians: Float): Float {
        return radians * 180.0f / PI
    }
}
