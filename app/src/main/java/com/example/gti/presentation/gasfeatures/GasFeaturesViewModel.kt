package com.example.gti.presentation.gasfeatures

import android.content.Context
import android.widget.Toast
import androidx.databinding.Observable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gti.databinding.FragmentGasFeaturesBinding
import com.example.gti.data.db.model.Gas
import kotlinx.coroutines.launch
import java.util.*

class GasFeaturesViewModel() : ViewModel(), Observable{

   /* fun saveGasFeature(context: Context, binding: FragmentGasFeaturesBinding) {
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

            val gasFeature = Gas(
                0,
                travelDistance,
                litersConsumed,
                gasPrice,
                currentDate
            )

            insert(gasFeature)
        }
    }*/

   /* private fun insert(gas: Gas) = viewModelScope.launch {
        val index = gasRepository.insert(gas)
        val test: String
    }*/

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

}