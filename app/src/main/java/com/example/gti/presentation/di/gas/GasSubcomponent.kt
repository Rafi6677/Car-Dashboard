package com.example.gti.presentation.di.gas

import com.example.gti.presentation.gasfeatures.GasFeaturesFragment
import dagger.Subcomponent

@GasScope
@Subcomponent(modules = [GasModule::class])
interface GasSubcomponent {

    fun inject(gasFeaturesFragment: GasFeaturesFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): GasSubcomponent
    }

}