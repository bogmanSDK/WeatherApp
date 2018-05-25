package com.sergey.bogush.weatherapp.ui.info

import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import com.sergey.bogush.weatherapp.R
import com.sergey.bogush.weatherapp.presentation.model.WeatherView
import com.sergey.bogush.weatherapp.presentation.info.WeatherContract
import dagger.android.AndroidInjection
import com.sergey.bogush.weatherapp.ui.mapper.WeatherMapper
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by Sergey on 5/25/2018.
 */

class InfoActivity: Activity(), WeatherContract.View {

    @Inject lateinit var mPresenter: WeatherContract.Presenter
    @Inject lateinit var mapper: WeatherMapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        weather_widget.onRotation()
    }

    override fun onStart() {
        super.onStart()
        mPresenter.start()
    }

    override fun setPresenter(presenter: WeatherContract.Presenter) {
        mPresenter = presenter
    }

    override fun hideProgress() {
    }

    override fun showProgress() {
    }

    override fun showWeather(weather: WeatherView) {
        weather_widget.updateUI(weather)
    }

    override fun showErrorState() {
    }

    override fun hideErrorState() {
    }
}