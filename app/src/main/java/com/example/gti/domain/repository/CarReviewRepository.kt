package com.example.gti.domain.repository

import com.example.gti.data.db.model.CarReview

interface CarReviewRepository {

    suspend fun insertCarReview(carReview: CarReview)
    suspend fun updateCarReview(carReview: CarReview)
    suspend fun deleteCarReview(carReview: CarReview)
    suspend fun deleteAllCarReview()
    suspend fun getAllCarReview(): List<CarReview>
    suspend fun getLatestCarReview(): CarReview

}