package com.example.gti.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gti.db.model.CarReview

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
    fun getAllCarReviewData(): LiveData<List<CarReview>>

    @Query("SELECT * FROM car_review WHERE car_review_timestamp = (SELECT MAX(car_review_timestamp) FROM car_review)")
    fun getLatestCarReviewData(): LiveData<CarReview>

}