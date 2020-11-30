package com.example.gti.domain.usecase

import com.example.gti.domain.repository.OilCheckRepository

class GetLatestOilCheckUseCase(private val oilCheckRepository: OilCheckRepository) {

    suspend fun execute() = oilCheckRepository.getLatestOilCheck()

}