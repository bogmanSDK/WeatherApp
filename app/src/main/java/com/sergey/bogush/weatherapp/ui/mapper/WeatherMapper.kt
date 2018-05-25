package com.sergey.bogush.weatherapp.ui.mapper

import com.sergey.bogush.weatherapp.presentation.model.WeatherView
import com.sergey.bogush.weatherapp.ui.model.WeatherViewModel
import javax.inject.Inject

/**
 * Created by Sergey on 5/25/2018.
 */

open class WeatherMapper @Inject constructor() : Mapper<WeatherViewModel, WeatherView> {

    override fun mapToViewModel(type: WeatherView): WeatherViewModel {
        return WeatherViewModel(type.coord,
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