package com.example.gti.domain.usecase

import com.example.gti.domain.repository.CarReviewRepository

class GetLatestCarReviewUseCase(private val carReviewRepository: CarReviewRepository) {

    suspend fun execute() = carReviewRepository.getLatestCarReview()

}