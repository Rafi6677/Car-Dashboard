package com.example.gti.presentation.gas.add

import android.content.Context
import android.widget.Toast
import androidx.databinding.Observable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gti.R
import com.example.gti.data.db.model.Gas
import com.example.gti.databinding.FragmentAddFuelConsumptionBinding
import com.example.gti.domain.usecase.InsertGasUseCase
import kotlinx.coroutines.launch
import java.util.*

class GasFeaturesViewModel(
    private val insertGasUseCase: InsertGasUseCase
) : ViewModel(), Observable{

    fun saveGasFeature(context: Context, binding: FragmentAddFuelConsumptionBinding) {
        val mileageText = binding.leftTextView.text.toString()
        val fuelText = binding.middleTextView.text.toString()

        if (mileageText == "0.0" || mileageText == "0" || fuelText == "0.0" || fuelText == "0") {
            Toast.makeText(context, "Uzupełnij dane.", Toast.LENGTH_SHORT)
                .show()
        } else {
            val gasPriceText = binding.rightTextView.text.toString()

            val travelDistance = mileageText.toDouble()
            val litersConsumed = fuelText.toDouble()
            var gasPrice: Double = 0.toDouble()
            val currentDate = Date().time

            if (gasPriceText != "0.0" || gasPriceText == "0") {
                gasPrice = gasPriceText.toDouble()
            }

            val gas = Gas(
                0,
                travelDistance,
                litersConsumed,
                gasPrice,
                currentDate
            )

            insert(context, gas)
        }
    }

    private fun insert(context: Context, gas: Gas) = viewModelScope.launch {
        insertGasUseCase.execute(gas)

        Toast.makeText(context, context.resources.getString(R.string.average_fuel_save), Toast.LENGTH_SHORT)
            .show()
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

}