package com.example.gti.domain.repository

import com.example.gti.data.db.model.FiltersChange

interface FiltersChangeRepository {

    suspend fun insertOilChange(filtersChange: FiltersChange)
    suspend fun updateOilChange(filtersChange: FiltersChange)
    suspend fun deleteOilChange(filtersChange: FiltersChange)
    suspend fun deleteAllOilChange()
    suspend fun getAllOilChange(): List<FiltersChange>
    suspend fun getLatestFiltersChange(): FiltersChange
    suspend fun getLatestOilFilterChange(): FiltersChange
    suspend fun getLatestAirFilterChange(): FiltersChange
    suspend fun getLatestCabinFilterChange(): FiltersChange

}