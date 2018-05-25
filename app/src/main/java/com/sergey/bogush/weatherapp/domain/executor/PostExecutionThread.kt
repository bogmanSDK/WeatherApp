package com.sergey.bogush.weatherapp.domain.executor

import io.reactivex.Scheduler

/**
 * Created by Sergey on 5/25/2018.
 */

interface PostExecutionThread {
    val scheduler: Scheduler
}