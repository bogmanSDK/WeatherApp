package com.sergey.bogush.weatherapp.ui.utils

import android.content.Context

import com.sergey.bogush.weatherapp.R

import org.apache.commons.lang3.StringUtils

import java.util.ArrayList

/**
 * Created by Sergey on 5/25/2018.
 */

object GeoDirection {

    val TAG = "GeoDirection"

    private val None = 0
    private val North = 1
    private val NorthEast = 1 shl 1
    private val East = 1 shl 2
    private val SouthEast = 1 shl 3
    private val South = 1 shl 4
    private val SouthWest = 1 shl 5
    private val West = 1 shl 6
    private val NorthWest = 1 shl 7
    private val All = North or NorthEast or East or SouthEast or South or SouthWest or West or NorthWest

    private fun contains(direction: Int, flag: Int): Boolean {
        return direction and flag == flag
    }

    fun union(direction: Int, flag: Int): Int {
        return direction or flag
    }

    fun subtract(direction: Int, flag: Int): Int {
        return direction and flag.inv()
    }

    fun format(context: Context, direction: Int): String {
        if (direction == None)
            return context.resources.getString(R.string.dir_none)
        if (direction == All)
            return context.resources.getString(R.string.dir_all)
        val arr = ArrayList<String>(7)
        if (contains(direction, North))
            arr.add(context.resources.getString(R.string.dir_north))
        if (contains(direction, NorthEast))
            arr.add(context.resources.getString(R.string.dir_north_east))
        if (contains(direction, East))
            arr.add(context.resources.getString(R.string.dir_east))
        if (contains(direction, SouthEast))
            arr.add(context.resources.getString(R.string.dir_south_east))
        if (contains(direction, South))
            arr.add(context.resources.getString(R.string.dir_south))
        if (contains(direction, SouthWest))
            arr.add(context.resources.getString(R.string.dir_south_west))
        if (contains(direction, West))
            arr.add(context.resources.getString(R.string.dir_west))
        if (contains(direction, NorthWest))
            arr.add(context.resources.getString(R.string.dir_north_west))
        return StringUtils.join(arr, ", ")
    }

    fun getCode(context: Context, azimuth: Int): String {
        return context.resources.getString(getCodeID(azimuth))
    }

    private fun getCodeID(azimuth: Int): Int {
        var azimuth = azimuth

        azimuth = MathUtils.norm_0_360(azimuth)

        if (azimuth < 113) {

            if (azimuth < 23)
                return R.string.dir_north
            return if (azimuth < 68) R.string.dir_north_east else R.string.dir_east

        } else if (azimuth < 248) {

            if (azimuth < 158)
                return R.string.dir_south_east
            return if (azimuth < 203) R.string.dir_south else R.string.dir_south_west

        } else {

            if (azimuth < 293)
                return R.string.dir_west
            return if (azimuth < 338) R.string.dir_north_west else R.string.dir_north
        }
    }
}
