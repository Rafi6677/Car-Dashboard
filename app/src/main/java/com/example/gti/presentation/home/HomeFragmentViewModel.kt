package com.example.gti.presentation.home

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gti.R
import com.example.gti.db.repository.*
import java.text.DecimalFormat

class HomeFragmentViewModel(
    private val carInsuranceRepository: CarInsuranceRepository,
    private val carReviewRepository: CarReviewRepository,
    private val gasRepository: GasRepository,
    private val oilChangeRepository: OilChangeRepository,
    private val oilCheckRepository: OilCheckRepository
) : ViewModel(), Observable {

    private val latestCarInsuranceData = carInsuranceRepository.latestCarInsuranceData
    private val latestCarReviewData = carReviewRepository.latestCarReview
    private val latestGasData = gasRepository.latestGasData
    private val latestOilChangeData = oilChangeRepository.latestOilChangeData
    private val latestOilCheckData = oilCheckRepository.latestOilCheckData

    private val decimalFormat = DecimalFormat("#.##")

    @Bindable
    val gasLatestFuelConsumption = MutableLiveData<String>()

    init {

        val gas = latestGasData.value

        if (gas != null) {
            gasLatestFuelConsumption.value = gas.litersConsumed.toString() + " " + R.string.average_fuel_consumption_value
        } else {
            gasLatestFuelConsumption.value = "12.5  l/100km"
        }
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

}