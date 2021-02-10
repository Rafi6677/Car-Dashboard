package com.example.gti.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gti.domain.usecase.GetLatestGasUseCase
import com.example.gti.domain.usecase.GetLatestOilChangeUseCase
import com.example.gti.domain.usecase.GetLatestOilCheckUseCase
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(
    private val getLatestGasDataUseCase: GetLatestGasUseCase,
    private val getLatestOilChangeUseCase: GetLatestOilChangeUseCase,
    private val getLatestOilCheckUseCase: GetLatestOilCheckUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(
                getLatestGasDataUseCase,
                getLatestOilChangeUseCase,
                getLatestOilCheckUseCase
            ) as T
        }

        throw IllegalArgumentException("Unknown View Model Class")
    }

}