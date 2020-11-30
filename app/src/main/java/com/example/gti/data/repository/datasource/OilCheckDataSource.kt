package com.example.gti.data.repository.datasource

import com.example.gti.data.db.model.OilCheck

interface OilCheckDataSource {

    suspend fun insertOilCheckIntoDB(oilCheck: OilCheck)
    suspend fun updateOilCheckToDB(oilCheck: OilCheck)
    suspend fun deleteOilCheckFromDB(oilCheck: OilCheck)
    suspend fun deleteAllOilCheckFromDB()
    suspend fun getAllOilCheckFromDB(): List<OilCheck>
    suspend fun getLatestOilCheckFromDB(): OilCheck

}