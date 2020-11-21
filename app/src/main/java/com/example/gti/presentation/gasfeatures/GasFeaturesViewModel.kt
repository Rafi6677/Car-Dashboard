package com.example.gti.presentation.gasfeatures

import androidx.databinding.Observable
import androidx.lifecycle.ViewModel
import com.example.gti.db.repository.GasRepository
import java.util.*

class GasFeaturesViewModel(
    private val gasRepository: GasRepository
) : ViewModel(), Observable{



    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}

}