package com.sergey.bogush.weatherapp.ui.model

import com.sergey.bogush.weatherapp.remote.model.*

/**
 * Created by Sergey on 5/25/2018.
 */

class WeatherViewModel(val coord: Coord,
                       val weather: List<Weather>,
                       val base: String,
                       val main: Main,
                       val visibility: Int,
                       val wind: Wind,
                       val clouds: Clouds,
                       val dt: Int,
                       val sys: Sys,
                       val id: Int,
                       val name: String,
                       val cod: Int)