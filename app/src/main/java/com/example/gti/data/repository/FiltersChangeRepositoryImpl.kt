package com.example.gti.data.repository

import android.util.Log
import com.example.gti.data.db.model.FiltersChange
import com.example.gti.data.repository.datasource.FiltersChangeDataSource
import com.example.gti.domain.repository.FiltersChangeRepository
import java.lang.Exception

class FiltersChangeRepositoryImpl(private val filtersChangeDataSource: FiltersChangeDataSource) : FiltersChangeRepository {

    override suspend fun insertOilChange(filtersChange: FiltersChange) {
        filtersChangeDataSource.insertOilChangeIntoDB(filtersChange)
    }

    override suspend fun updateOilChange(filtersChange: FiltersChange) {
        filtersChangeDataSource.updateOilChangeToDB(filtersChange)
    }

    override suspend fun deleteOilChange(filtersChange: FiltersChange) {
        filtersChangeDataSource.deleteOilChangeFromDB(filtersChange)
    }

    override suspend fun deleteAllOilChange() {
        filtersChangeDataSource.deleteAllOilChangeFromDB()
    }

    override suspend fun getAllOilChange(): List<FiltersChange> {
        lateinit var filtersChangeList: List<FiltersChange>

        try {
            filtersChangeList = filtersChangeDataSource.getAllOilChangeFromDB()
        } catch (e: Exception) {
            Log.i("ExceptionTag", e.message.toString())
        }

        return filtersChangeList
    }

    override suspend fun getLatestFiltersChange(): FiltersChange {
        lateinit var latestFiltersChange: FiltersChange

        try {
            latestFiltersChange = filtersChangeDataSource.getLatestOilChangeFromDB()
        } catch (e: Exception) {
            Log.i("ExceptionTag", e.message.toString())
        }

        return latestFiltersChange
    }

    override suspend fun getLatestOilFilterChange(): FiltersChange {
        lateinit var latestFiltersChange: FiltersChange

        try {
            latestFiltersChange = filtersChangeDataSource.getLatestOilFilterChangeFromDB()
        } catch (e: Exception) {
            Log.i("ExceptionTag", e.message.toString())
        }

        return latestFiltersChange
    }

    override suspend fun getLatestAirFilterChange(): FiltersChange {
        lateinit var latestFiltersChange: FiltersChange

        try {
            latestFiltersChange = filtersChangeDataSource.getLatestAirFilterChangeFromDB()
        } catch (e: Exception) {
            Log.i("ExceptionTag", e.message.toString())
        }

        return latestFiltersChange
    }

    override suspend fun getLatestCabinFilterChange(): FiltersChange {
        lateinit var latestFiltersChange: FiltersChange

        try {
            latestFiltersChange = filtersChangeDataSource.getLatestCabinFilterChangeFromDB()
        } catch (e: Exception) {
            Log.i("ExceptionTag", e.message.toString())
        }

        return latestFiltersChange
    }

}