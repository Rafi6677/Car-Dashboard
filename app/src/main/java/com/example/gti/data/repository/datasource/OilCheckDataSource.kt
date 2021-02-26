package com.example.gti.data.repository.datasource

import androidx.lifecycle.LiveData
import com.example.gti.data.db.model.OilCheck

interface OilCheckDataSource {

    suspend fun insertOilCheckIntoDB(oilCheck: OilCheck)
    suspend fun updateOilCheckToDB(oilCheck: OilCheck)
    suspend fun deleteOilCheckFromDB(oilCheck: OilCheck)
    suspend fun deleteAllOilCheckFromDB()
    fun getAllOilCheckFromDB(): LiveData<List<OilCheck>>
    suspend fun getLatestOilCheckFromDB(): OilCheck

}