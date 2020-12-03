package com.example.gti.presentation.gas.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gti.domain.usecase.DeleteGasUseCase
import com.example.gti.domain.usecase.EditGasUseCase
import com.example.gti.domain.usecase.GetAllGasUseCase
import java.lang.IllegalArgumentException

class GasConsumptionHistoryViewModelFactory(
    private val getAllGasUseCase: GetAllGasUseCase,
    private val editGasUseCase: EditGasUseCase,
    private val deleteGasUseCase: DeleteGasUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GasConsumptionHistoryViewModel::class.java)) {
            return GasConsumptionHistoryViewModel(
                getAllGasUseCase,
                editGasUseCase,
                deleteGasUseCase
            ) as T
        }

        throw IllegalArgumentException("Unknown View Model Class")
    }

}