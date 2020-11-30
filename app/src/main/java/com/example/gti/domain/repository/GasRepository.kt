package com.example.gti.domain.repository

import com.example.gti.data.db.model.Gas

interface GasRepository {

    suspend fun insertGas(gas: Gas)
    suspend fun updateGas(gas: Gas)
    suspend fun deleteGas(gas: Gas)
    suspend fun deleteAllGas()
    suspend fun getAllGas(): List<Gas>
    suspend fun getLatestGas(): Gas?

}