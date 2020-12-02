package com.example.gti.presentation.di

import com.example.gti.presentation.di.gas.GasSubcomponent
import com.example.gti.presentation.di.home.HomeSubcomponent

interface Injector {

    fun createHomeSubcomponent(): HomeSubcomponent
    fun createGasSubcomponent(): GasSubcomponent

}