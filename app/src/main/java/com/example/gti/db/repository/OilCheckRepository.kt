package com.example.gti.db.repository

import com.example.gti.db.dao.OilCheckDAO
import com.example.gti.db.model.OilCheck

class OilCheckRepository(private val dao: OilCheckDAO) {

    val oilCheckDataList = dao.getAllOilCheckData()

    suspend fun insert(oilCheck: OilCheck): Long {
        return dao.insertOilCheckData(oilCheck)
    }

    suspend fun update(oilCheck: OilCheck): Int {
        return dao.updateOilCheckData(oilCheck)
    }

    suspend fun delete(oilCheck: OilCheck): Int {
        return dao.deleteOilCheckData(oilCheck)
    }

    suspend fun deleteAll(): Int {
        return dao.deleteAllOilCheckData()
    }

}