package com.sergey.bogush.weatherapp.data.repository

import io.reactivex.Single
import com.sergey.bogush.weatherapp.data.model.WeatherEntity

/**
 * Created by Sergey on 5/25/2018.
 */

interface WeatherRemote {

    fun getWeather(): Single<WeatherEntity>
}
