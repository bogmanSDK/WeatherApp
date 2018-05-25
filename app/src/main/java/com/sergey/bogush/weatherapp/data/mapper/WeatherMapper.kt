package com.sergey.bogush.weatherapp.data.mapper

import com.sergey.bogush.weatherapp.domain.model.Weather
import com.sergey.bogush.weatherapp.data.model.WeatherEntity
import javax.inject.Inject

/**
 * Created by Sergey on 5/25/2018.
 */

open class WeatherMapper @Inject constructor() : Mapper<WeatherEntity, Weather> {

    override fun mapFromEntity(type: WeatherEntity): Weather {
        return Weather(
                type.coord,
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

    override fun mapToEntity(type: Weather): WeatherEntity {
        return WeatherEntity(
                type.coord,
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