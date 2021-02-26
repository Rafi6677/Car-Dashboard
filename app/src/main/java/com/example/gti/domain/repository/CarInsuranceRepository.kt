package com.example.gti.domain.repository

import androidx.lifecycle.LiveData
import com.example.gti.data.db.model.CarInsurance

interface CarInsuranceRepository {

    suspend fun insertCarInsurance(carInsurance: CarInsurance)
    suspend fun updateCarInsurance(carInsurance: CarInsurance)
    suspend fun deleteCarInsurance(carInsurance: CarInsurance)
    suspend fun deleteAllCarInsurance()
    fun getAllCarInsurance(): LiveData<List<CarInsurance>>
    suspend fun getLatestCarInsurance(): CarInsurance

}