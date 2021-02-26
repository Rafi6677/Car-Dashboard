package com.example.gti.data.repository.datasourceimpl

import androidx.lifecycle.LiveData
import com.example.gti.data.db.dao.CarReviewDAO
import com.example.gti.data.db.model.CarReview
import com.example.gti.data.repository.datasource.CarReviewDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CarReviewDataSourceImpl(private val dao: CarReviewDAO) : CarReviewDataSource {

    override suspend fun insertCarReviewIntoDB(carReview: CarReview) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertCarReviewData(carReview)
        }
    }

    override suspend fun updateCarReviewToDB(carReview: CarReview) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.updateCarReviewData(carReview)
        }
    }

    override suspend fun deleteCarReviewFromDB(carReview: CarReview) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteCarReviewData(carReview)
        }
    }

    override suspend fun deleteAllCarReviewFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllCarReviewData()
        }
    }

    override fun getAllCarReviewFromDB(): LiveData<List<CarReview>> = dao.getAllCarReviewData()

    override suspend fun getLatestCarReviewFromDB(): CarReview = dao.getLatestCarReviewData()

}
