package com.example.gti.presentation.di.gas.add

import com.example.gti.domain.usecase.InsertGasUseCase
import com.example.gti.presentation.gas.add.GasFeaturesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class GasModule {

    @GasScope
    @Provides
    fun provideGasViewModelFactory(
        insertGasUseCase: InsertGasUseCase
    ): GasFeaturesViewModelFactory {
        return GasFeaturesViewModelFactory(
            insertGasUseCase
        )
    }

}