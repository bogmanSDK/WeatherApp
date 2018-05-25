package com.sergey.bogush.weatherapp.data.repository

import com.sergey.bogush.weatherapp.data.model.WeatherEntity
import io.reactivex.Single

/**
 * Created by Sergey on 5/25/2018.
 */

interface WeatherDataStore {

    fun getWeather(): Single<WeatherEntity>

}