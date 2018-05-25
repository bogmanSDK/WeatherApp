package com.sergey.bogush.weatherapp.ui

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import com.sergey.bogush.weatherapp.domain.executor.PostExecutionThread
import javax.inject.Inject

/**
 * Created by Sergey on 5/25/2018.
 */

class UiThread @Inject internal constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()

}