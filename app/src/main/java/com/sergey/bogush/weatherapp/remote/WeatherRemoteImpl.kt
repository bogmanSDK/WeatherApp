package com.sergey.bogush.weatherapp.remote

import com.sergey.bogush.weatherapp.BuildConfig
import com.sergey.bogush.weatherapp.data.repository.WeatherRemote
import com.sergey.bogush.weatherapp.remote.mapper.WeatherEntityMapper
import io.reactivex.Single
import com.sergey.bogush.weatherapp.data.model.WeatherEntity
import javax.inject.Inject

/**
 * Created by Sergey on 5/25/2018.
 */

class WeatherRemoteImpl @Inject constructor(private val weatherService: WeatherService,
                                            private val entityMapper: WeatherEntityMapper) : WeatherRemote {

    override fun getWeather(): Single<WeatherEntity> {
        return weatherService.getWeather(BuildConfig.CITY, BuildConfig.APPID)
                .map { item ->
                    entityMapper.mapFromRemote(item)
                }
    }
}