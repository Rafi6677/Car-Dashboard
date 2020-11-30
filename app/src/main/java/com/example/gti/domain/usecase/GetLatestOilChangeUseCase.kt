package com.example.gti.domain.usecase

import com.example.gti.domain.repository.OilChangeRepository

class GetLatestOilChangeUseCase(private val oilChangeRepository: OilChangeRepository) {

    suspend fun execute() = oilChangeRepository.getLatestOilChange()

}