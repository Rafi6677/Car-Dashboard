package com.example.gti.presentation.di.gas.add

import com.example.gti.presentation.gas.add.AddFuelConsumptionFragment
import dagger.Subcomponent

@GasScope
@Subcomponent(modules = [GasModule::class])
interface GasSubcomponent {

    fun inject(addFuelConsumptionFragment: AddFuelConsumptionFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): GasSubcomponent
    }

}