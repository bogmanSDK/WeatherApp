package com.sergey.bogush.weatherapp.ui.info.widgets

import android.animation.Animator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.sergey.bogush.weatherapp.R
import com.sergey.bogush.weatherapp.presentation.model.WeatherView
import com.sergey.bogush.weatherapp.ui.utils.GeoDirection
import com.sergey.bogush.weatherapp.ui.utils.SpeedConverter
import com.sergey.bogush.weatherapp.ui.utils.TemperatureConverter

/**
 * Created by Sergey on 5/25/2018.
 */

class WeatherWidget(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    private val cell_view1: View
    private val cell_view2: View
    private val cell_view3: View

    private val weather_wind_direction: TextView
    private val weather_wind_speed: TextView
    private val compass_pointer_image: ImageView
    private val compass_image: ImageView

    init {
        val root = View.inflate(context, R.layout.weather_widget_layout, this)
        root.setOnClickListener(null)

        cell_view1 = findViewById(R.id.forecast_cell_1)
        cell_view2 = findViewById(R.id.forecast_cell_2)
        cell_view3 = findViewById(R.id.forecast_cell_3)

        weather_wind_direction = findViewById(R.id.weather_wind_direction)
        weather_wind_speed = findViewById(R.id.weather_wind_speed)
        compass_pointer_image = findViewById(R.id.compass_pointer_image)
        compass_image = findViewById(R.id.compass_image)
    }

    fun updateUI(weather: WeatherView) {
        updateCellUI(cell_view1, weather)
        updateCellUI(cell_view2, weather)
        updateCellUI(cell_view3, weather)

        updateCompassUI(weather)
    }

    private fun updateCellUI(cell_view: View, weather: WeatherView) {
        val weather_temperature = cell_view.findViewById<TextView>(R.id.weather_temperature)
        val weather_humidity = cell_view.findViewById<TextView>(R.id.weather_humidity)
        val weather_icon = cell_view.findViewById<ImageView>(R.id.weather_icon)

        val temperature = TemperatureConverter.formatConvertedValue(weather.main.temp)
        weather_temperature.text = temperature

        val humidity = String.format("%d %%", Math.round(weather.main.humidity.toFloat()))
        weather_humidity.visibility = View.VISIBLE
        weather_humidity.text = humidity
    }

    private fun updateCompassUI(weatherInfo: WeatherView) {
        compass_image.visibility = View.VISIBLE
        compass_pointer_image.visibility = View.VISIBLE
        compass_pointer_image.rotation = weatherInfo.wind.deg.toFloat()

        val direction = GeoDirection.getCode(context, weatherInfo.wind.deg)
        weather_wind_direction.text = direction

        val speed = SpeedConverter.formatConvertedValue(weatherInfo.wind.speed)
        weather_wind_speed.text = speed
    }

    fun onRotation() {
        YoYo.with(Techniques.FadeInDown).duration(1000).playOn(this)
    }
}
