package com.example.gti.data.repository

import android.util.Log
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

    override suspend fun getAllGas(): List<Gas> {
        lateinit var gasList: List<Gas>

        try {
            gasList = gasDataSource.getAllGasFromDB()
        } catch (e: Exception) {
            Log.i("ExceptionTag", e.message.toString())
        }

        return gasList
    }

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