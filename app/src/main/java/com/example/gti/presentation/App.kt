package com.example.gti.presentation

import android.app.Application
import com.example.gti.presentation.di.Injector
import com.example.gti.presentation.di.core.AppComponent
import com.example.gti.presentation.di.core.AppModule
import com.example.gti.presentation.di.core.DaggerAppComponent
import com.example.gti.presentation.di.home.HomeSubcomponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }

    override fun createHomeSubComponent(): HomeSubcomponent {
        return appComponent.homeSubComponent().create()
    }

}