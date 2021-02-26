package com.example.gti.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
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

    override fun getAllCarInsurance(): LiveData<List<CarInsurance>> = carInsuranceDataSource.getAllCarInsuranceFromDB()

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