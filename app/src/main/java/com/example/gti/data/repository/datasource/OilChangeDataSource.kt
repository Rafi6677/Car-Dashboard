package com.example.gti.data.repository.datasource

import com.example.gti.data.db.model.OilChange

interface OilChangeDataSource {

    suspend fun insertOilChangeIntoDB(oilChange: OilChange)
    suspend fun updateOilChangeToDB(oilChange: OilChange)
    suspend fun deleteOilChangeFromDB(oilChange: OilChange)
    suspend fun deleteAllOilChangeFromDB()
    suspend fun getAllOilChangeFromDB(): List<OilChange>
    suspend fun getLatestOilChangeFromDB(): OilChange

}