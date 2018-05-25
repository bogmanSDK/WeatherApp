package com.sergey.bogush.weatherapp.ui.mapper

/**
 * Created by Sergey on 4/19/2017.
 */

interface Mapper<out V, in D> {

    fun mapToViewModel(type: D): V

}