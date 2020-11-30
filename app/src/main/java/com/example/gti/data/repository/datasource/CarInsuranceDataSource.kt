package com.example.gti.data.repository.datasource

import com.example.gti.data.db.model.CarInsurance

interface CarInsuranceDataSource {

    suspend fun insertCarInsuranceIntoDB(carInsurance: CarInsurance)
    suspend fun updateCarInsuranceToDB(carInsurance: CarInsurance)
    suspend fun deleteCarInsuranceFromDB(carInsurance: CarInsurance)
    suspend fun deleteAllCarInsuranceFromDB()
    suspend fun getAllCarInsuranceFromDB(): List<CarInsurance>
    suspend fun getLatestCarInsuranceFromDB(): CarInsurance

}