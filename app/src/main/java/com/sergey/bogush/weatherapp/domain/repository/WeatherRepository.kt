package com.sergey.bogush.weatherapp.domain.repository

import com.sergey.bogush.weatherapp.domain.model.Weather
import io.reactivex.Single

/**
 * Created by Sergey on 5/25/2018.
 */

interface WeatherRepository {

    fun getWeather(): Single<Weather>

}