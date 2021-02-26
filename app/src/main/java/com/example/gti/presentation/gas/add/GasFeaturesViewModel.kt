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
) : ViewModel(), Observable {

    fun saveGasFeature(
        context: Context,
        binding: FragmentAddFuelConsumptionBinding
    ): Boolean {
        val distanceText = binding.distanceValueTextView.text.toString()
        val fuelText = binding.fuelValueTextView.text.toString()

        if (distanceText == "0.0" || fuelText == "0.0") {
            Toast.makeText(context, "Uzupełnij dane.", Toast.LENGTH_SHORT)
                .show()

            return false
        } else {
            val gasPriceText = binding.priceValueTextView.text.toString()

            val travelDistance = distanceText.toDouble()
            val litersConsumed = fuelText.toDouble()
            val fuelPrice = if (gasPriceText != "0.0") gasPriceText.toDouble() else 0.toDouble()
            val currentDate = Date().time

            val gas = Gas(
                0,
                travelDistance,
                litersConsumed,
                fuelPrice,
                currentDate
            )

            insert(context, gas)
            return true
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