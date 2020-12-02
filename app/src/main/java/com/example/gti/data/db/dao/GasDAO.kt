package com.example.gti.data.db.dao

import androidx.room.*
import com.example.gti.data.db.model.Gas

@Dao
interface GasDAO {

    @Insert
    suspend fun insertGasData(gas: Gas)

    @Update
    suspend fun updateGasData(gas: Gas): Int

    @Delete
    suspend fun deleteGasData(gas: Gas): Int

    @Query("DELETE FROM gas_features")
    suspend fun deleteAllGasData(): Int

    @Query("SELECT * FROM gas_features")
    suspend fun getAllGasData(): List<Gas>

    @Query("SELECT * FROM gas_features WHERE last_refueling_timestamp = (SELECT MAX(last_refueling_timestamp) FROM gas_features)")
    suspend fun getLatestGasData(): Gas

}