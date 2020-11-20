package com.example.gti.db.repository

import com.example.gti.db.dao.GasDAO
import com.example.gti.db.model.Gas

class GasRepository(private val dao: GasDAO) {

    val gasDataList = dao.getAllGasData()
    val latestGasData = dao.getLatestGasData()

    suspend fun insert(gas: Gas): Long {
        return dao.insertGasData(gas)
    }

    suspend fun update(gas: Gas): Int {
        return dao.updateGasData(gas)
    }

    suspend fun delete(gas: Gas): Int {
        return dao.deleteGasData(gas)
    }

    suspend fun deleteAll(): Int {
        return dao.deleteAllGasData()
    }

}