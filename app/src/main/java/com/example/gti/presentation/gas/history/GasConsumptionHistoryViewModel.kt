package com.example.gti.presentation.gas.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.gti.data.db.model.Gas
import com.example.gti.domain.usecase.DeleteGasUseCase
import com.example.gti.domain.usecase.EditGasUseCase
import com.example.gti.domain.usecase.GetAllGasUseCase
import kotlinx.coroutines.launch

class GasConsumptionHistoryViewModel(
    private val getAllGasUseCase: GetAllGasUseCase,
    private val editGasUseCase: EditGasUseCase,
    private val deleteGasUseCase: DeleteGasUseCase
) : ViewModel() {

    val allGasConsumptionData = getAllGasUseCase.execute()

    fun deleteGasData(gas: Gas)= viewModelScope.launch {
        deleteGasUseCase.execute(gas)
    }

}