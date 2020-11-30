package com.example.gti.data.repository.datasource

import com.example.gti.data.db.model.Gas

interface GasDataSource {

    suspend fun insertGasIntoDB(gas: Gas)
    suspend fun updateGasToDB(gas: Gas)
    suspend fun deleteGasFromDB(gas: Gas)
    suspend fun deleteAllGasFromDB()
    suspend fun getAllGasFromDB(): List<Gas>
    suspend fun getLatestGasFromDB(): Gas

}