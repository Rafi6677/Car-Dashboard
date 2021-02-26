package com.example.gti.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.gti.data.db.model.CarReview
import com.example.gti.data.repository.datasource.CarReviewDataSource
import com.example.gti.domain.repository.CarReviewRepository
import java.lang.Exception

class CarReviewRepositoryImpl(private val carReviewDataSource: CarReviewDataSource) : CarReviewRepository {

    override suspend fun insertCarReview(carReview: CarReview) {
        carReviewDataSource.insertCarReviewIntoDB(carReview)
    }

    override suspend fun updateCarReview(carReview: CarReview) {
        carReviewDataSource.updateCarReviewToDB(carReview)
    }

    override suspend fun deleteCarReview(carReview: CarReview) {
        carReviewDataSource.deleteCarReviewFromDB(carReview)
    }

    override suspend fun deleteAllCarReview() {
        carReviewDataSource.deleteAllCarReviewFromDB()
    }

    override fun getAllCarReview(): LiveData<List<CarReview>> = carReviewDataSource.getAllCarReviewFromDB()

    override suspend fun getLatestCarReview(): CarReview {
        lateinit var latestCarReview: CarReview

        try {
            latestCarReview = carReviewDataSource.getLatestCarReviewFromDB()
        } catch (e: Exception) {
            Log.i("ExceptionTag", e.message.toString())
        }

        return latestCarReview
    }

}