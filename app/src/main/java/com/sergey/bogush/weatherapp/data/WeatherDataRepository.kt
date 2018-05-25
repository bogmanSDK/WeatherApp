package com.sergey.bogush.weatherapp.data

import com.sergey.bogush.weatherapp.data.mapper.WeatherMapper
import com.sergey.bogush.weatherapp.data.source.WeatherDataStoreFactory
import com.sergey.bogush.weatherapp.domain.model.Weather
import com.sergey.bogush.weatherapp.domain.repository.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Sergey on 5/25/2018.
 */

class WeatherDataRepository @Inject constructor(private val factory: WeatherDataStoreFactory,
                                                private val weatherMapper: WeatherMapper) :
        WeatherRepository {
    override fun getWeather(): Single<Weather> {
        return factory.retrieveRemoteDataStore().getWeather()
                .map { item ->
                        weatherMapper.mapFromEntity(item)
                    }
                }
    }