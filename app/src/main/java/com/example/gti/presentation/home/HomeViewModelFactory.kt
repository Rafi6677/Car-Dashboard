package com.example.gti.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gti.domain.usecase.GetLatestGasUseCase
import java.lang.IllegalArgumentException

class HomeViewModelFactory(
    private val getLatestGasDataUseCase: GetLatestGasUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(getLatestGasDataUseCase) as T
        }

        throw IllegalArgumentException("Unknown View Model Class")
    }

}