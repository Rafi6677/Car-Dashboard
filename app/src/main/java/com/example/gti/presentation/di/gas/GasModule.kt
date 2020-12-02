package com.example.gti.presentation.di.gas

import com.example.gti.domain.usecase.InsertGasUseCase
import com.example.gti.presentation.di.home.HomeScope
import com.example.gti.presentation.gasfeatures.GasFeaturesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class GasModule {

    @GasScope
    @Provides
    fun provideGasViewModelFactory(
        insertGasUseCase: InsertGasUseCase
    ): GasFeaturesViewModelFactory {
        return GasFeaturesViewModelFactory(insertGasUseCase)
    }

}