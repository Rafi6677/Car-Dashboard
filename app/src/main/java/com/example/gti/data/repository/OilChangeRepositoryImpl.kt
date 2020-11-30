package com.example.gti.data.repository

import android.util.Log
import com.example.gti.data.db.model.OilChange
import com.example.gti.data.repository.datasource.OilChangeDataSource
import com.example.gti.domain.repository.OilChangeRepository
import java.lang.Exception

class OilChangeRepositoryImpl(private val oilChangeDataSource: OilChangeDataSource) : OilChangeRepository {

    override suspend fun insertOilChange(oilChange: OilChange) {
        oilChangeDataSource.insertOilChangeIntoDB(oilChange)
    }

    override suspend fun updateOilChange(oilChange: OilChange) {
        oilChangeDataSource.updateOilChangeToDB(oilChange)
    }

    override suspend fun deleteOilChange(oilChange: OilChange) {
        oilChangeDataSource.deleteOilChangeFromDB(oilChange)
    }

    override suspend fun deleteAllOilChange() {
        oilChangeDataSource.deleteAllOilChangeFromDB()
    }

    override suspend fun getAllOilChange(): List<OilChange> {
        lateinit var oilChangeList: List<OilChange>

        try {
            oilChangeList = oilChangeDataSource.getAllOilChangeFromDB()
        } catch (e: Exception) {
            Log.i("ExceptionTag", e.message.toString())
        }

        return oilChangeList
    }

    override suspend fun getLatestOilChange(): OilChange {
        lateinit var latestOilChange: OilChange

        try {
            latestOilChange = oilChangeDataSource.getLatestOilChangeFromDB()
        } catch (e: Exception) {
            Log.i("ExceptionTag", e.message.toString())
        }

        return latestOilChange
    }

}