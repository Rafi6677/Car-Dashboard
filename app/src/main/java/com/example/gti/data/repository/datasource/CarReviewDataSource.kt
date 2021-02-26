package com.example.gti.data.repository.datasource

import androidx.lifecycle.LiveData
import com.example.gti.data.db.model.CarReview

interface CarReviewDataSource {

    suspend fun insertCarReviewIntoDB(carReview: CarReview)
    suspend fun updateCarReviewToDB(carReview: CarReview)
    suspend fun deleteCarReviewFromDB(carReview: CarReview)
    suspend fun deleteAllCarReviewFromDB()
    fun getAllCarReviewFromDB(): LiveData<List<CarReview>>
    suspend fun getLatestCarReviewFromDB(): CarReview

}