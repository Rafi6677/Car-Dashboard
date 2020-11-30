package com.example.gti.data.repository.datasourceimpl

import com.example.gti.data.db.dao.OilChangeDAO
import com.example.gti.data.db.model.OilChange
import com.example.gti.data.repository.datasource.OilChangeDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OilChangeDataSourceImpl(private val dao: OilChangeDAO) : OilChangeDataSource {

    override suspend fun insertOilChangeIntoDB(oilChange: OilChange) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertOilChangeData(oilChange)
        }
    }

    override suspend fun updateOilChangeToDB(oilChange: OilChange) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.updateOilChangeData(oilChange)
        }
    }

    override suspend fun deleteOilChangeFromDB(oilChange: OilChange) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteOilChangeData(oilChange)
        }
    }

    override suspend fun deleteAllOilChangeFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllOilChangeData()
        }
    }

    override suspend fun getAllOilChangeFromDB(): List<OilChange> = dao.getAllOilChangeData()

    override suspend fun getLatestOilChangeFromDB(): OilChange = dao.getLatestOilChangeData()

}