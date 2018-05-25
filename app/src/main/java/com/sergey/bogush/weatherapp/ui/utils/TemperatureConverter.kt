package com.sergey.bogush.weatherapp.ui.utils

/**
 * Created by Sergey on 5/25/2018.
 */

object TemperatureConverter {

    fun formatConvertedValue(value: Double): String {
        return Math.round(kelvinTocelsius(value)).toString() + "\u00B0C"
    }

    private fun fahrenheitToCelsius(value: Double): Double {
        return (value - 32.0) * 5.0 / 9.0
    }

    private fun celsiusToFahrenheit(value: Double): Double {
        return value * 9.0 / 5.0 + 32.0
    }

    private fun kelvinTocelsius(value: Double): Double {
        return value - 273.15
    }
}