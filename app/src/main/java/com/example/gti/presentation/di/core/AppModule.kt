package com.example.gti.presentation.di.core

import android.content.Context
import com.example.gti.presentation.di.home.HomeSubcomponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [HomeSubcomponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }

}