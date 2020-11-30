package com.example.gti.presentation.home

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.*
import com.example.gti.data.db.model.Gas
import com.example.gti.domain.usecase.GetLatestGasUseCase
import java.text.DecimalFormat

class HomeViewModel(
    private val getLatestGasDataUseCase: GetLatestGasUseCase
) : ViewModel(), Observable {

    @Bindable
    val gasLatestFuelConsumption = MutableLiveData<String>()

    fun getLatestGasData() = liveData {
        val latestGasData = getLatestGasDataUseCase.execute()
        emit(latestGasData)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

}