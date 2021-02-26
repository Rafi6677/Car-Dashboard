package com.example.gti.domain.repository

import androidx.lifecycle.LiveData
import com.example.gti.data.db.model.CarReview

interface CarReviewRepository {

    suspend fun insertCarReview(carReview: CarReview)
    suspend fun updateCarReview(carReview: CarReview)
    suspend fun deleteCarReview(carReview: CarReview)
    suspend fun deleteAllCarReview()
    fun getAllCarReview(): LiveData<List<CarReview>>
    suspend fun getLatestCarReview(): CarReview

}