package com.sergey.bogush.weatherapp.ui.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.sergey.bogush.weatherapp.ui.info.InfoActivity
import com.sergey.bogush.weatherapp.ui.injection.scopes.PerActivity

/**
 * Created by Sergey on 5/25/2018.
 */

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [(InfoActivityModule::class)])
    abstract fun bindMainActivity(): InfoActivity

}