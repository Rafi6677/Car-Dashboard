package com.example.gti.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gti.data.db.model.OilCheck

@Dao
interface OilCheckDAO {

    @Insert
    suspend fun insertOilCheckData(oilCheck: OilCheck): Long

    @Update
    suspend fun updateOilCheckData(oilCheck: OilCheck): Int

    @Delete
    suspend fun deleteOilCheckData(oilCheck: OilCheck): Int

    @Query("DELETE FROM oil_level_features")
    suspend fun deleteAllOilCheckData(): Int

    @Query("SELECT * FROM oil_level_features")
    fun getAllOilCheckData(): LiveData<List<OilCheck>>

    @Query("SELECT * FROM oil_level_features WHERE last_oil_check_timestamp = (SELECT MAX(last_oil_check_timestamp) FROM oil_level_features)")
    suspend fun getLatestOilCheckData(): OilCheck

}