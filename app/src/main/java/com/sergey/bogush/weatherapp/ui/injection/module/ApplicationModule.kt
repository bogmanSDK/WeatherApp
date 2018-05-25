package com.sergey.bogush.weatherapp.ui.injection.module

import android.app.Application
import android.content.Context
import com.sergey.bogush.weatherapp.BuildConfig
import com.sergey.bogush.weatherapp.data.WeatherDataRepository
import com.sergey.bogush.weatherapp.data.repository.WeatherRemote
import com.sergey.bogush.weatherapp.remote.WeatherRemoteImpl
import com.sergey.bogush.weatherapp.remote.WeatherService
import com.sergey.bogush.weatherapp.remote.WeatherServiceFactory
import com.sergey.bogush.weatherapp.remote.mapper.WeatherEntityMapper
import dagger.Module
import dagger.Provides
import com.sergey.bogush.weatherapp.data.executor.JobExecutor
import com.sergey.bogush.weatherapp.data.mapper.WeatherMapper
import com.sergey.bogush.weatherapp.data.source.WeatherDataStoreFactory
import com.sergey.bogush.weatherapp.domain.executor.PostExecutionThread
import com.sergey.bogush.weatherapp.domain.executor.ThreadExecutor
import com.sergey.bogush.weatherapp.domain.repository.WeatherRepository
import com.sergey.bogush.weatherapp.ui.UiThread
import com.sergey.bogush.weatherapp.ui.injection.scopes.PerApplication

/**
 * Created by Sergey on 5/25/2018.
 */

@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRemote(service: WeatherService,
                                       factory: WeatherEntityMapper): WeatherRemote {
        return WeatherRemoteImpl(service, factory)
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun provideWeatherRepository(factory: WeatherDataStoreFactory,
                                          mapper: WeatherMapper): WeatherRepository {
        return WeatherDataRepository(factory, mapper)
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    internal fun provideBufferooService(): WeatherService {
        return WeatherServiceFactory.makeWeatherService(BuildConfig.DEBUG)
    }
}
