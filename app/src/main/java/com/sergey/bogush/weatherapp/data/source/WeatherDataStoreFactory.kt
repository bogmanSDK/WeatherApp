package com.sergey.bogush.weatherapp.data.source

import com.sergey.bogush.weatherapp.data.repository.WeatherDataStore
import javax.inject.Inject

/**
 * Created by Sergey on 5/25/2018.
 */

open class WeatherDataStoreFactory @Inject constructor(
        private val weatherRemoteDataStore: WeatherRemoteDataStore) {

    open fun retrieveRemoteDataStore(): WeatherDataStore {
        return weatherRemoteDataStore
    }
}