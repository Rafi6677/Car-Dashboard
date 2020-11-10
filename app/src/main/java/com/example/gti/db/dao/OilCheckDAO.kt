package com.example.gti.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.gti.db.model.OilCheck

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

}