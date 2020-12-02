package com.example.gti.utils

import com.example.gti.data.db.model.Gas
import java.math.BigDecimal
import java.math.RoundingMode

object CalculationUtils {

    fun calculateFuelConsumptionToString(gas: Gas): String {
        val fuelConsumption = ((gas.litersConsumed * 100) / gas.travelDistance)

        return BigDecimal(fuelConsumption)
            .setScale(2, RoundingMode.HALF_UP)
            .toString()
    }

}