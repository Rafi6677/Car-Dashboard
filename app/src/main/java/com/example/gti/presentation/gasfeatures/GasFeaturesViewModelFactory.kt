package com.example.gti.presentation.gasfeatures

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gti.db.repository.GasRepository
import java.lang.IllegalArgumentException

class GasFeaturesViewModelFactory(
    private val gasRepository: GasRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GasFeaturesViewModel::class.java)) {
            return GasFeaturesViewModel(gasRepository) as T
        }

        throw IllegalArgumentException("Unknown View Model Class")
    }

}