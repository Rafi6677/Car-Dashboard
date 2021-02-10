package com.example.gti.presentation.home

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.*
import com.example.gti.data.db.model.Gas
import com.example.gti.domain.usecase.GetLatestGasUseCase
import com.example.gti.domain.usecase.GetLatestOilChangeUseCase
import com.example.gti.domain.usecase.GetLatestOilCheckUseCase
import java.text.DecimalFormat

class HomeViewModel(
    private val getLatestGasDataUseCase: GetLatestGasUseCase,
    private val getLatestOilChangeUseCase: GetLatestOilChangeUseCase,
    private val getLatestOilCheckUseCase: GetLatestOilCheckUseCase
) : ViewModel(), Observable {

    @Bindable
    val gasLatestFuelConsumption = MutableLiveData<String>()

    @Bindable
    val latestOilChangeDate = MutableLiveData<String>()

    @Bindable
    val latestOilLevel = MutableLiveData<String>()

    fun getLatestGasData() = liveData {
        val latestGasData = getLatestGasDataUseCase.execute()
        emit(latestGasData)
    }

    fun getLatestOilChange() = liveData {
        val latestOilChange = getLatestOilChangeUseCase.execute()
        emit(latestOilChange)
    }

    fun getLatestOilLevel() = liveData {
        val latestOilLevel = getLatestOilCheckUseCase.execute()
        emit(latestOilLevel)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

}