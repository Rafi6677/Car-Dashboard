package com.example.gti.data.repository.datasourceimpl

import androidx.lifecycle.LiveData
import com.example.gti.data.db.dao.GasDAO
import com.example.gti.data.db.model.Gas
import com.example.gti.data.repository.datasource.GasDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GasDataSourceImpl(private val dao: GasDAO) : GasDataSource {

    override suspend fun insertGasIntoDB(gas: Gas) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertGasData(gas)
        }
    }

    override suspend fun updateGasToDB(gas: Gas) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.updateGasData(gas)
        }
    }

    override suspend fun deleteGasFromDB(gas: Gas) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteGasData(gas)
        }
    }

    override suspend fun deleteAllGasFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllGasData()
        }
    }

    override fun getAllGasFromDB(): LiveData<List<Gas>> = dao.getAllGasData()

    override suspend fun getLatestGasFromDB(): Gas = dao.getLatestGasData()

}