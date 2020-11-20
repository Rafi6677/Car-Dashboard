package com.example.gti.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gti.db.model.Gas

@Dao
interface GasDAO {

    @Insert
    suspend fun insertGasData(gas: Gas): Long

    @Update
    suspend fun updateGasData(gas: Gas): Int

    @Delete
    suspend fun deleteGasData(gas: Gas): Int

    @Query("DELETE FROM gas_features")
    suspend fun deleteAllGasData(): Int

    @Query("SELECT * FROM gas_features")
    fun getAllGasData(): LiveData<List<Gas>>

    @Query("SELECT * FROM gas_features WHERE last_refueling_timestamp = (SELECT MAX(last_refueling_timestamp) FROM gas_features)")
    fun getLatestGasData(): LiveData<Gas>

}