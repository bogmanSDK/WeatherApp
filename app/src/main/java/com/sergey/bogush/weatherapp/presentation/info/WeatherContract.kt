package com.sergey.bogush.weatherapp.presentation.info

import com.sergey.bogush.weatherapp.presentation.model.WeatherView
import com.sergey.bogush.weatherapp.presentation.BasePresenter
import com.sergey.bogush.weatherapp.presentation.BaseView

/**
 * Created by Sergey on 5/25/2018.
 */

interface WeatherContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showWeather(weather: WeatherView)

        fun showErrorState()

        fun hideErrorState()

    }

    interface Presenter : BasePresenter {

        fun retrieveWeather()

    }
}