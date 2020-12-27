package com.example.gti.data.db.dao

import androidx.room.*
import com.example.gti.data.db.model.FiltersChange

@Dao
interface FiltersChangeDAO {

    @Insert
    suspend fun insertFiltersChangeData(filtersChange: FiltersChange): Long

    @Update
    suspend fun updateFiltersChangeData(filtersChange: FiltersChange): Int

    @Delete
    suspend fun deleteFiltersChangeData(filtersChange: FiltersChange): Int

    @Query("DELETE FROM filters_change")
    suspend fun deleteAllFiltersChangeData(): Int

    @Query("SELECT * FROM filters_change")
    suspend fun getAllFiltersChangeData(): List<FiltersChange>

    @Query("SELECT * FROM filters_change WHERE last_oil_change_timestamp = (SELECT MAX(last_oil_change_timestamp) FROM filters_change)")
    suspend fun getLatestOilChangeData(): FiltersChange

    @Query("SELECT * FROM filters_change WHERE last_oil_filter_change_timestamp = (SELECT MAX(last_oil_filter_change_timestamp) FROM filters_change)")
    suspend fun getLatestOilFilterChangeData(): FiltersChange

    @Query("SELECT * FROM filters_change WHERE last_air_filter_change_timestamp = (SELECT MAX(last_air_filter_change_timestamp) FROM filters_change)")
    suspend fun getLatestAirFilterChangeData(): FiltersChange

    @Query("SELECT * FROM filters_change WHERE last_cabin_filter_change_timestamp = (SELECT MAX(last_cabin_filter_change_timestamp) FROM filters_change)")
    suspend fun getLatestCabinFilterChangeData(): FiltersChange

}