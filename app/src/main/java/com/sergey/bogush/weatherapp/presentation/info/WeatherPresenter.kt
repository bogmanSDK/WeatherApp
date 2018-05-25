package com.sergey.bogush.weatherapp.presentation.info

import com.sergey.bogush.weatherapp.domain.model.Weather
import com.sergey.bogush.weatherapp.presentation.mapper.WeatherMapper
import io.reactivex.observers.DisposableSingleObserver
import com.sergey.bogush.weatherapp.domain.interactor.SingleUseCase
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.timerTask

/**
 * Created by Sergey on 5/25/2018.
 */

class WeatherPresenter @Inject constructor(val view: WeatherContract.View,
                                           val getWeatherUseCase: SingleUseCase<Weather, Void>,
                                           val weatherMapper: WeatherMapper) : WeatherContract.Presenter {

    private val timer = Timer()

    override fun retrieveWeather() {
        timer.schedule(timerTask { getWeatherUseCase.execute(WeatherSubscriber()) }, 0, 30 * 1000)
    }

    init {
        view.setPresenter(this)
    }

    override fun start() {
        retrieveWeather()
    }

    override fun stop() {
        getWeatherUseCase.dispose()
    }

    internal fun handleGetWeatherSuccess(weather: Weather) {
        view.showWeather(weatherMapper.mapToView(weather))
    }

    inner class WeatherSubscriber : DisposableSingleObserver<Weather>() {

        override fun onSuccess(weather: Weather) {
            handleGetWeatherSuccess(weather)
        }

        override fun onError(exception: Throwable) {
            view.showErrorState()
        }

    }

}