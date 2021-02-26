package com.example.gti.data.repository.datasourceimpl

import androidx.lifecycle.LiveData
import com.example.gti.data.db.dao.CarInsuranceDAO
import com.example.gti.data.db.model.CarInsurance
import com.example.gti.data.repository.datasource.CarInsuranceDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CarInsuranceDataSourceImpl(private val dao: CarInsuranceDAO) :
    CarInsuranceDataSource {

    override suspend fun insertCarInsuranceIntoDB(carInsurance: CarInsurance) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertCarInsuranceData(carInsurance)
        }
    }

    override suspend fun updateCarInsuranceToDB(carInsurance: CarInsurance) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.updateCarInsuranceData(carInsurance)
        }
    }

    override suspend fun deleteCarInsuranceFromDB(carInsurance: CarInsurance) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteCarInsuranceData(carInsurance)
        }
    }

    override suspend fun deleteAllCarInsuranceFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllCarInsuranceData()
        }
    }

    override fun getAllCarInsuranceFromDB(): LiveData<List<CarInsurance>> = dao.getAllCarInsuranceData()

    override suspend fun getLatestCarInsuranceFromDB(): CarInsurance = dao.getLatestCarInsuranceData()

}