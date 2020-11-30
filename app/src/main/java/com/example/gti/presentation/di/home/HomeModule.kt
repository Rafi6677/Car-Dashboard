package com.example.gti.presentation.di.home

import com.example.gti.domain.usecase.GetLatestGasUseCase
import com.example.gti.presentation.home.HomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @HomeScope
    @Provides
    fun provideHomeViewModelFactory(
        getLatestGasDataUseCase: GetLatestGasUseCase
    ): HomeViewModelFactory {
        return HomeViewModelFactory(getLatestGasDataUseCase)
    }

}