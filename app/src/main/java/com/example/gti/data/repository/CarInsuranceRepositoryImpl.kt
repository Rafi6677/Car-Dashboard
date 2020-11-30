package com.example.gti.data.repository

import android.util.Log
import com.example.gti.data.db.model.CarInsurance
import com.example.gti.data.repository.datasource.CarInsuranceDataSource
import com.example.gti.domain.repository.CarInsuranceRepository
import java.lang.Exception

class CarInsuranceRepositoryImpl(private val carInsuranceDataSource: CarInsuranceDataSource) : CarInsuranceRepository {

    override suspend fun insertCarInsurance(carInsurance: CarInsurance) {
        carInsuranceDataSource.insertCarInsuranceIntoDB(carInsurance)
    }

    override suspend fun updateCarInsurance(carInsurance: CarInsurance) {
        carInsuranceDataSource.updateCarInsuranceToDB(carInsurance)
    }

    override suspend fun deleteCarInsurance(carInsurance: CarInsurance) {
        carInsuranceDataSource.deleteCarInsuranceFromDB(carInsurance)
    }

    override suspend fun deleteAllCarInsurance() {
        carInsuranceDataSource.deleteAllCarInsuranceFromDB()
    }

    override suspend fun getAllCarInsurance(): List<CarInsurance> {
        lateinit var carInsuranceList: List<CarInsurance>

        try {
            carInsuranceList = carInsuranceDataSource.getAllCarInsuranceFromDB()
        } catch (e: Exception) {
            Log.i("ExceptionTag", e.message.toString())
        }

        return carInsuranceList
    }

    override suspend fun getLatestCarInsurance(): CarInsurance {
        lateinit var latestCarInsurance: CarInsurance

        try {
            latestCarInsurance = carInsuranceDataSource.getLatestCarInsuranceFromDB()
        } catch (e: Exception) {
            Log.i("ExceptionTag", e.message.toString())
        }

        return latestCarInsurance
    }

}