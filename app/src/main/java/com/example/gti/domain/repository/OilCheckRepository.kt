package com.example.gti.domain.repository

import com.example.gti.data.db.model.OilCheck

interface OilCheckRepository {

    suspend fun insertOilCheck(oilCheck: OilCheck)
    suspend fun updateOilCheck(oilCheck: OilCheck)
    suspend fun deleteOilCheck(oilCheck: OilCheck)
    suspend fun deleteAllOilCheck()
    suspend fun getAllOilCheck(): List<OilCheck>
    suspend fun getLatestOilCheck(): OilCheck?

}