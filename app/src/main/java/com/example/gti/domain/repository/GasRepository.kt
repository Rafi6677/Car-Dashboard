package com.example.gti.domain.repository

import androidx.lifecycle.LiveData
import com.example.gti.data.db.model.Gas

interface GasRepository {

    suspend fun insertGas(gas: Gas)
    suspend fun updateGas(gas: Gas)
    suspend fun deleteGas(gas: Gas)
    suspend fun deleteAllGas()
    fun getAllGas(): LiveData<List<Gas>>
    suspend fun getLatestGas(): Gas?

}