package com.sergey.bogush.weatherapp.presentation.mapper

import com.sergey.bogush.weatherapp.domain.model.Weather
import com.sergey.bogush.weatherapp.presentation.model.WeatherView
import javax.inject.Inject

/**
 * Created by Sergey on 5/25/2018.
 */

open class WeatherMapper @Inject constructor() : Mapper<WeatherView, Weather> {

    override fun mapToView(type: Weather): WeatherView {
        return WeatherView(type.coord,
                type.weather,
                type.base,
                type.main,
                type.visibility,
                type.wind,
                type.clouds,
                type.dt,
                type.sys,
                type.id,
                type.name,
                type.cod)
    }
}