package com.sergey.bogush.weatherapp.ui.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.sergey.bogush.weatherapp.ui.WeatherApplication
import com.sergey.bogush.weatherapp.ui.injection.module.ActivityBindingModule
import com.sergey.bogush.weatherapp.ui.injection.module.ApplicationModule
import com.sergey.bogush.weatherapp.ui.injection.scopes.PerApplication

/**
 * Created by Sergey on 5/25/2018.
 */

@PerApplication
@Component(modules = arrayOf(ActivityBindingModule::class, ApplicationModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: WeatherApplication)

}
