package com.sergey.bogush.weatherapp.remote.mapper

import com.sergey.bogush.weatherapp.remote.model.WeatherModel
import com.sergey.bogush.weatherapp.data.model.WeatherEntity
import javax.inject.Inject

/**
 * Created by Sergey on 5/25/2018.
 */

open class WeatherEntityMapper @Inject constructor() : EntityMapper<WeatherModel, WeatherEntity> {
    override fun mapFromRemote(type: WeatherModel): WeatherEntity {
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