package com.example.gti.presentation.di.core

import com.example.gti.presentation.di.gas.add.GasSubcomponent
import com.example.gti.presentation.di.gas.history.GasHistorySubcomponent
import com.example.gti.presentation.di.home.HomeSubcomponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    DataBaseModule::class,
    DataSourceModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {

    fun homeSubComponent(): HomeSubcomponent.Factory
    fun gasSubComponent(): GasSubcomponent.Factory
    fun gasHistorySubComponent(): GasHistorySubcomponent.Factory

}