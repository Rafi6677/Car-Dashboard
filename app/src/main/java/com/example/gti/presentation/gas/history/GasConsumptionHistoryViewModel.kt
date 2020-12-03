package com.example.gti.presentation.gas.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.gti.domain.usecase.DeleteGasUseCase
import com.example.gti.domain.usecase.EditGasUseCase
import com.example.gti.domain.usecase.GetAllGasUseCase

class GasConsumptionHistoryViewModel(
    private val getAllGasUseCase: GetAllGasUseCase,
    private val editGasUseCase: EditGasUseCase,
    private val deleteGasUseCase: DeleteGasUseCase
) : ViewModel() {

    fun getGasAllData() = liveData {
        val allGasData = getAllGasUseCase.execute()
        emit(allGasData)
    }

}