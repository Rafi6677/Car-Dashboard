package com.example.gti.presentation.gasfeatures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gti.domain.usecase.InsertGasUseCase
import java.lang.IllegalArgumentException

class GasFeaturesViewModelFactory(
    private val insertGasUseCase: InsertGasUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GasFeaturesViewModel::class.java)) {
            return GasFeaturesViewModel(insertGasUseCase) as T
        }

        throw IllegalArgumentException("Unknown View Model Class")
    }

}