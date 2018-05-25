package com.sergey.bogush.weatherapp.ui.injection.module

import com.sergey.bogush.weatherapp.domain.interactor.GetWeather
import com.sergey.bogush.weatherapp.presentation.mapper.WeatherMapper
import com.sergey.bogush.weatherapp.presentation.info.WeatherContract
import com.sergey.bogush.weatherapp.presentation.info.WeatherPresenter
import dagger.Module
import dagger.Provides
import com.sergey.bogush.weatherapp.ui.info.InfoActivity
import com.sergey.bogush.weatherapp.ui.injection.scopes.PerActivity

/**
 * Created by Sergey on 5/25/2018.
 */

@Module
open class InfoActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(browseActivity: InfoActivity): WeatherContract.View {
        return browseActivity
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(mainView: WeatherContract.View,
                                        getWeather: GetWeather, mapper: WeatherMapper):
            WeatherContract.Presenter {
        return WeatherPresenter(mainView, getWeather, mapper)
    }

}
