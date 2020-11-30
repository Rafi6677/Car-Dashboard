package com.example.gti.data.repository.datasource

import com.example.gti.data.db.model.CarReview

interface CarReviewDataSource {

    suspend fun insertCarReviewIntoDB(carReview: CarReview)
    suspend fun updateCarReviewToDB(carReview: CarReview)
    suspend fun deleteCarReviewFromDB(carReview: CarReview)
    suspend fun deleteAllCarReviewFromDB()
    suspend fun getAllCarReviewFromDB(): List<CarReview>
    suspend fun getLatestCarReviewFromDB(): CarReview

}