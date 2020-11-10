package com.example.gti.db.repository

import com.example.gti.db.dao.CarInsuranceDAO
import com.example.gti.db.model.CarInsurance

class CarInsuranceRepository(private val dao: CarInsuranceDAO) {

    val carInsuranceList = dao.getAllCarInsuranceData()

    suspend fun insert(carInsurance: CarInsurance): Long {
        return dao.insertCarInsuranceData(carInsurance)
    }

    suspend fun update(carInsurance: CarInsurance): Int {
        return dao.updateCarInsuranceData(carInsurance)
    }

    suspend fun delete(carInsurance: CarInsurance): Int {
        return dao.deleteCarInsuranceData(carInsurance)
    }

    suspend fun deleteAll(): Int {
        return dao.deleteAllCarInsuranceData()
    }

}