package com.sergey.bogush.weatherapp.ui.utils

/**
 * Created by Sergey on 5/25/2018.
 */

object SpeedConverter {

    private val METERS_PER_MILE = 1609.344

    fun formatConvertedValue(value: Double): String {
        return formatSpeedMetric(value)
    }

    fun formatConvertedValueKmH(value: Double): String {
        return formatSpeedMetricToKmH(value)
    }

    private fun formatSpeedMetricToKmH(meters_per_second: Double): String {
        return String.format("%.1f km/h", meters_per_second * 3.6)
    }

    private fun formatSpeedMetric(meters_per_second: Double): String {
        return String.format("%.1f m/s", meters_per_second)
    }

    private fun formatSpeedImperial(miles_per_hour: Double): String {
        return String.format("%.1f mph", miles_per_hour)
    }

    private fun metersPerSecondToMph(value: Double): Double {
        return value / METERS_PER_MILE * 3600.0
    }

    private fun mphToMetersPerSecond(value: Double): Double {
        return value * METERS_PER_MILE / 3600.0
    }
}
