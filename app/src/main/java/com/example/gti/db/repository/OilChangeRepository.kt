package com.example.gti.db.repository

import com.example.gti.db.dao.OilChangeDAO
import com.example.gti.db.model.OilChange

class OilChangeRepository(private val dao: OilChangeDAO) {

    val oilChangeDataList = dao.getAllOilChangeData()
    val latestOilChangeData = dao.getLatestOilChangeData()

    suspend fun insert(oilChange: OilChange): Long {
        return dao.insertOilChangeData(oilChange)
    }

    suspend fun update(oilChange: OilChange): Int {
        return dao.updateOilChangeData(oilChange)
    }

    suspend fun delete(oilChange: OilChange): Int {
        return dao.deleteOilChangeData(oilChange)
    }

    suspend fun deleteAll(): Int {
        return dao.deleteAllOilChangeData()
    }

}