package com.example.gti.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.gti.data.db.model.OilCheck
import com.example.gti.data.repository.datasource.OilCheckDataSource
import com.example.gti.domain.repository.OilCheckRepository
import java.lang.Exception

class OilCheckRepositoryImpl(private val oilCheckDataSource: OilCheckDataSource) : OilCheckRepository {

    override suspend fun insertOilCheck(oilCheck: OilCheck) {
        oilCheckDataSource.insertOilCheckIntoDB(oilCheck)
    }

    override suspend fun updateOilCheck(oilCheck: OilCheck) {
        oilCheckDataSource.updateOilCheckToDB(oilCheck)
    }

    override suspend fun deleteOilCheck(oilCheck: OilCheck) {
        oilCheckDataSource.deleteOilCheckFromDB(oilCheck)
    }

    override suspend fun deleteAllOilCheck() {
        oilCheckDataSource.deleteAllOilCheckFromDB()
    }

    override fun getAllOilCheck(): LiveData<List<OilCheck>> = oilCheckDataSource.getAllOilCheckFromDB()

    override suspend fun getLatestOilCheck(): OilCheck? {
        var latestOilCheck: OilCheck? = null

        try {
            latestOilCheck = oilCheckDataSource.getLatestOilCheckFromDB()
        } catch (e: Exception) {
            Log.i("ExceptionTag", e.message.toString())
        }

        return latestOilCheck
    }

}