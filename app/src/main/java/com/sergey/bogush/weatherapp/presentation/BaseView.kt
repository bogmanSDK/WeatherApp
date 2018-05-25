package com.sergey.bogush.weatherapp.presentation

/**
 * Created by Sergey on 5/25/2018.
 */

interface BaseView<in T : BasePresenter> {

    fun setPresenter(presenter: T)

}