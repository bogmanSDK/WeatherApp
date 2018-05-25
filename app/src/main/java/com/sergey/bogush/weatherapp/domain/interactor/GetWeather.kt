package com.sergey.bogush.weatherapp.domain.interactor

import com.sergey.bogush.weatherapp.domain.model.Weather
import com.sergey.bogush.weatherapp.domain.repository.WeatherRepository
import io.reactivex.Single
import com.sergey.bogush.weatherapp.domain.executor.PostExecutionThread
import com.sergey.bogush.weatherapp.domain.executor.ThreadExecutor
import javax.inject.Inject

/**
 * Created by Sergey on 5/25/2018.
 */

open class GetWeather @Inject constructor(val weatherRepository: WeatherRepository,
                                          threadExecutor: ThreadExecutor,
                                          postExecutionThread: PostExecutionThread) :
        SingleUseCase<Weather, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<Weather> {
        return weatherRepository.getWeather()
    }

}