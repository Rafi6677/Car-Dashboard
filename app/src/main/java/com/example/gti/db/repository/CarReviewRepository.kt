package com.example.gti.db.repository

import com.example.gti.db.dao.CarReviewDAO
import com.example.gti.db.model.CarReview

class CarReviewRepository(private val dao: CarReviewDAO) {

    val carReviewList = dao.getAllCarReviewData()
    val latestCarReview = dao.getLatestCarReviewData()

    suspend fun insert(carReview: CarReview): Long {
        return dao.insertCarReviewData(carReview)
    }

    suspend fun update(carReview: CarReview): Int {
        return dao.updateCarReviewData(carReview)
    }

    suspend fun delete(carReview: CarReview): Int {
        return dao.deleteCarReviewData(carReview)
    }

    suspend fun deleteAll(): Int {
        return dao.deleteAllCarReviewData()
    }

}