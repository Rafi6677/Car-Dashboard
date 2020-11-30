package com.example.gti.data.repository.datasourceimpl

import com.example.gti.data.db.dao.OilCheckDAO
import com.example.gti.data.db.model.OilCheck
import com.example.gti.data.repository.datasource.OilCheckDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OilCheckDataSourceImpl(private val dao: OilCheckDAO) : OilCheckDataSource {

    override suspend fun insertOilCheckIntoDB(oilCheck: OilCheck) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertOilCheckData(oilCheck)
        }
    }

    override suspend fun updateOilCheckToDB(oilCheck: OilCheck) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.updateOilCheckData(oilCheck)
        }
    }

    override suspend fun deleteOilCheckFromDB(oilCheck: OilCheck) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteOilCheckData(oilCheck)
        }
    }

    override suspend fun deleteAllOilCheckFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllOilCheckData()
        }
    }

    override suspend fun getAllOilCheckFromDB(): List<OilCheck> = dao.getAllOilCheckData()

    override suspend fun getLatestOilCheckFromDB(): OilCheck = dao.getLatestOilCheckData()

}