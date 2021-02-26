package com.example.gti.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.gti.data.db.model.Gas
import com.example.gti.data.repository.datasource.GasDataSource
import com.example.gti.domain.repository.GasRepository
import java.lang.Exception

class GasRepositoryImpl(private val gasDataSource: GasDataSource): GasRepository {

    override suspend fun insertGas(gas: Gas) {
        gasDataSource.insertGasIntoDB(gas)
    }

    override suspend fun updateGas(gas: Gas) {
        gasDataSource.updateGasToDB(gas)
    }

    override suspend fun deleteGas(gas: Gas) {
        gasDataSource.deleteGasFromDB(gas)
    }

    override suspend fun deleteAllGas() {
        gasDataSource.deleteAllGasFromDB()
    }

    override fun getAllGas(): LiveData<List<Gas>> = gasDataSource.getAllGasFromDB()

    override suspend fun getLatestGas(): Gas? {
        var latestGas: Gas? = null

        try {
            latestGas = gasDataSource.getLatestGasFromDB()
        } catch (e: Exception) {
            Log.i("ExceptionTag", e.message.toString())
        }

        return latestGas
    }

}