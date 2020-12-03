package com.example.gti.presentation.di.gas.history

import com.example.gti.domain.usecase.DeleteGasUseCase
import com.example.gti.domain.usecase.EditGasUseCase
import com.example.gti.domain.usecase.GetAllGasUseCase
import com.example.gti.presentation.gas.history.GasConsumptionHistoryViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class GasHistoryModule {

    @GasHistoryScope
    @Provides
    fun provideGasConsumptionHistoryViewModelFactory(
        getAllGasUseCase: GetAllGasUseCase,
        editGasUseCase: EditGasUseCase,
        deleteGasUseCase: DeleteGasUseCase
    ): GasConsumptionHistoryViewModelFactory {
        return GasConsumptionHistoryViewModelFactory(
            getAllGasUseCase,
            editGasUseCase,
            deleteGasUseCase
        )
    }

}