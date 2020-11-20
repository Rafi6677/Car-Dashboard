package com.example.gti.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gti.db.repository.*
import java.lang.IllegalArgumentException

class HomeFragmentViewModelFactory(
    private val carInsuranceRepository: CarInsuranceRepository,
    private val carReviewRepository: CarReviewRepository,
    private val gasRepository: GasRepository,
    private val oilChangeRepository: OilChangeRepository,
    private val oilCheckRepository: OilCheckRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeFragmentViewModel::class.java)) {
            return HomeFragmentViewModel(
                carInsuranceRepository,
                carReviewRepository,
                gasRepository,
                oilChangeRepository,
                oilCheckRepository
            ) as T
        }

        throw IllegalArgumentException("Unknown View Model Class")
    }

}