package com.sergey.bogush.weatherapp.ui.injection.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import com.sergey.bogush.weatherapp.ui.info.InfoActivity

/**
 * Created by Sergey on 5/25/2018.
 */

@Subcomponent
interface InfoActivitySubComponent : AndroidInjector<InfoActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<InfoActivity>()

}