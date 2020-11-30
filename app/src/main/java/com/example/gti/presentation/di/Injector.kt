package com.example.gti.presentation.di

import com.example.gti.presentation.di.home.HomeSubcomponent

interface Injector {

    fun createHomeSubComponent(): HomeSubcomponent

}