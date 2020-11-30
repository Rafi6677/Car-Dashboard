package com.example.gti.domain.repository

import com.example.gti.data.db.model.OilChange

interface OilChangeRepository {

    suspend fun insertOilChange(oilChange: OilChange)
    suspend fun updateOilChange(oilChange: OilChange)
    suspend fun deleteOilChange(oilChange: OilChange)
    suspend fun deleteAllOilChange()
    suspend fun getAllOilChange(): List<OilChange>
    suspend fun getLatestOilChange(): OilChange

}