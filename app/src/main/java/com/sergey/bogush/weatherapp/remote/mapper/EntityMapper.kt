package com.sergey.bogush.weatherapp.remote.mapper

/**
 * Created by Sergey on 5/25/2018.
 */

interface EntityMapper<in M, out E> {

    fun mapFromRemote(type: M): E

}