package com.example.gti.data.repository.datasource

import androidx.lifecycle.LiveData
import com.example.gti.data.db.model.CarInsurance

interface CarInsuranceDataSource {

    suspend fun insertCarInsuranceIntoDB(carInsurance: CarInsurance)
    suspend fun updateCarInsuranceToDB(carInsurance: CarInsurance)
    suspend fun deleteCarInsuranceFromDB(carInsurance: CarInsurance)
    suspend fun deleteAllCarInsuranceFromDB()
    fun getAllCarInsuranceFromDB(): LiveData<List<CarInsurance>>
    suspend fun getLatestCarInsuranceFromDB(): CarInsurance

}