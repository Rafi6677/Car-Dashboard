package com.example.gti.data.repository.datasource

import androidx.lifecycle.LiveData
import com.example.gti.data.db.model.Gas

interface GasDataSource {

    suspend fun insertGasIntoDB(gas: Gas)
    suspend fun updateGasToDB(gas: Gas)
    suspend fun deleteGasFromDB(gas: Gas)
    suspend fun deleteAllGasFromDB()
    fun getAllGasFromDB(): LiveData<List<Gas>>
    suspend fun getLatestGasFromDB(): Gas

}