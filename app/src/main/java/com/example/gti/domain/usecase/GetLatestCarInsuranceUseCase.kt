package com.example.gti.domain.usecase

import com.example.gti.domain.repository.CarInsuranceRepository

class GetLatestCarInsuranceUseCase(private val carInsuranceRepository: CarInsuranceRepository) {

    suspend fun execute() = carInsuranceRepository.getLatestCarInsurance()

}