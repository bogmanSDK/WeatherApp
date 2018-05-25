package com.sergey.bogush.weatherapp.data.source

import com.sergey.bogush.weatherapp.data.model.WeatherEntity
import com.sergey.bogush.weatherapp.data.repository.WeatherDataStore
import com.sergey.bogush.weatherapp.data.repository.WeatherRemote
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Sergey on 5/25/2018.
 */

open class WeatherRemoteDataStore @Inject constructor(private val weatherRemote: WeatherRemote) :
        WeatherDataStore {
    override fun getWeather(): Single<WeatherEntity> {
       return weatherRemote.getWeather()
    }


}