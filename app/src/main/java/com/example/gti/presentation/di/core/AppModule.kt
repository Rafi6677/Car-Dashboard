package com.example.gti.presentation.di.core

import android.content.Context
import com.example.gti.presentation.di.exploitation.actualization.ExploitationElementActualizationSubcomponent
import com.example.gti.presentation.di.gas.add.GasSubcomponent
import com.example.gti.presentation.di.gas.history.GasHistorySubcomponent
import com.example.gti.presentation.di.home.HomeSubcomponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
    HomeSubcomponent::class,
    GasSubcomponent::class,
    GasHistorySubcomponent::class,
    ExploitationElementActualizationSubcomponent::class
])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }

}