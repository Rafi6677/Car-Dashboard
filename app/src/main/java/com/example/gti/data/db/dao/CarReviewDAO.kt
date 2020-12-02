package com.example.gti.data.db.dao

import androidx.room.*
import com.example.gti.data.db.model.CarReview

@Dao
interface CarReviewDAO {

    @Insert
    suspend fun insertCarReviewData(carReview: CarReview): Long

    @Update
    suspend fun updateCarReviewData(carReview: CarReview): Int

    @Delete
    suspend fun deleteCarReviewData(carReview: CarReview): Int

    @Query("DELETE FROM car_review")
    suspend fun deleteAllCarReviewData(): Int

    @Query("SELECT * FROM car_review")
    suspend fun getAllCarReviewData(): List<CarReview>

    @Query("SELECT * FROM car_review WHERE car_review_timestamp = (SELECT MAX(car_review_timestamp) FROM car_review)")
    suspend fun getLatestCarReviewData(): CarReview

}