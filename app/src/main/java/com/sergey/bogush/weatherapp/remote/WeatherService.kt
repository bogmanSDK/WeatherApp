package com.sergey.bogush.weatherapp.remote

import com.sergey.bogush.weatherapp.remote.model.WeatherModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Sergey on 5/25/2018.
 */

interface WeatherService {

    @GET("/data/2.5/weather")
    fun getWeather(
            @Query("q") city: String,
            @Query("APPID") appId: String
    ): Single<WeatherModel>

}
