package com.sergey.bogush.weatherapp.presentation.mapper

/**
 * Created by Sergey on 5/25/2018.
 */

interface Mapper<out V, in D> {

    fun mapToView(type: D): V

}