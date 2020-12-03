package com.example.gti.utils

import com.example.gti.data.db.model.Gas
import java.math.BigDecimal
import java.math.RoundingMode

object CalculationUtils {

    fun calculateFuelConsumptionToString(gas: Gas): String {
        val fuelConsumption = ((gas.litersConsumed * 100) / gas.travelDistance)

        return StringUtils.getStringFromDouble(fuelConsumption)
    }

    fun calculateGasRefuelingPrice(gas: Gas): String {
        val totalPrice = (gas.litersConsumed * gas.gasPrice)

        return StringUtils.getStringFromDouble(totalPrice)
    }

}