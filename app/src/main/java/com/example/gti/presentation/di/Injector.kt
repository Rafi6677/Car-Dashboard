package com.example.gti.presentation.di

import com.example.gti.presentation.di.exploitation.actualization.ExploitationElementActualizationSubcomponent
import com.example.gti.presentation.di.exploitation.exploitation.ExploitationSubcomponent
import com.example.gti.presentation.di.gas.add.GasSubcomponent
import com.example.gti.presentation.di.gas.history.GasHistorySubcomponent
import com.example.gti.presentation.di.home.HomeSubcomponent

interface Injector {

    fun createHomeSubcomponent(): HomeSubcomponent
    fun createGasSubcomponent(): GasSubcomponent
    fun createGasHistorySubcomponent(): GasHistorySubcomponent
    fun createExploitationSubcomponent(): ExploitationSubcomponent
    fun createExploitationElementActualizationSubcomponent(): ExploitationElementActualizationSubcomponent

}