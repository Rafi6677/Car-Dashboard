package com.example.gti.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gti.db.model.OilChange

@Dao
interface OilChangeDAO {

    @Insert
    suspend fun insertOilChangeData(oilChange: OilChange): Long

    @Update
    suspend fun updateOilChangeData(oilChange: OilChange): Int

    @Delete
    suspend fun deleteOilChangeData(oilChange: OilChange): Int

    @Query("DELETE FROM oil_change_features")
    suspend fun deleteAllOilChangeData(): Int

    @Query("SELECT * FROM oil_change_features")
    fun getAllOilChangeData(): LiveData<List<OilChange>>

}