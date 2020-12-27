package com.example.gti.data.repository.datasourceimpl

import com.example.gti.data.db.dao.FiltersChangeDAO
import com.example.gti.data.db.model.FiltersChange
import com.example.gti.data.repository.datasource.FiltersChangeDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FiltersChangeDataSourceImpl(private val dao: FiltersChangeDAO) : FiltersChangeDataSource {

    override suspend fun insertOilChangeIntoDB(filtersChange: FiltersChange) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertFiltersChangeData(filtersChange)
        }
    }

    override suspend fun updateOilChangeToDB(filtersChange: FiltersChange) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.updateFiltersChangeData(filtersChange)
        }
    }

    override suspend fun deleteOilChangeFromDB(filtersChange: FiltersChange) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteFiltersChangeData(filtersChange)
        }
    }

    override suspend fun deleteAllOilChangeFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllFiltersChangeData()
        }
    }

    override suspend fun getAllOilChangeFromDB(): List<FiltersChange> = dao.getAllFiltersChangeData()

    override suspend fun getLatestOilChangeFromDB(): FiltersChange = dao.getLatestOilChangeData()

    override suspend fun getLatestOilFilterChangeFromDB(): FiltersChange = dao.getLatestOilFilterChangeData()

    override suspend fun getLatestAirFilterChangeFromDB(): FiltersChange = dao.getLatestAirFilterChangeData()

    override suspend fun getLatestCabinFilterChangeFromDB(): FiltersChange = dao.getLatestCabinFilterChangeData()

}