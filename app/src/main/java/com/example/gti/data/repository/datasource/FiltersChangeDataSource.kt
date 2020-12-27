package com.example.gti.data.repository.datasource

import com.example.gti.data.db.model.FiltersChange

interface FiltersChangeDataSource {

    suspend fun insertOilChangeIntoDB(filtersChange: FiltersChange)
    suspend fun updateOilChangeToDB(filtersChange: FiltersChange)
    suspend fun deleteOilChangeFromDB(filtersChange: FiltersChange)
    suspend fun deleteAllOilChangeFromDB()
    suspend fun getAllOilChangeFromDB(): List<FiltersChange>
    suspend fun getLatestOilChangeFromDB(): FiltersChange
    suspend fun getLatestOilFilterChangeFromDB(): FiltersChange
    suspend fun getLatestAirFilterChangeFromDB(): FiltersChange
    suspend fun getLatestCabinFilterChangeFromDB(): FiltersChange

}