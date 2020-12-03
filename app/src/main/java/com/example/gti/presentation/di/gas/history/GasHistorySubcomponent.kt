package com.example.gti.presentation.di.gas.history

import com.example.gti.presentation.gas.history.GasConsumptionHistoryFragment
import dagger.Subcomponent

@GasHistoryScope
@Subcomponent(modules = [GasHistoryModule::class])
interface GasHistorySubcomponent {

    fun inject(gasConsumptionHistoryFragment: GasConsumptionHistoryFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): GasHistorySubcomponent
    }

}