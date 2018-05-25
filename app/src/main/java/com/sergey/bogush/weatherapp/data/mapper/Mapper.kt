package com.sergey.bogush.weatherapp.data.mapper

/**
 * Created by Sergey on 5/25/2018.
 */

interface Mapper<E, D> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E

}