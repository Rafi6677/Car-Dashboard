package com.example.gti.domain.usecase

import com.example.gti.domain.repository.ExploitationPartChangeRepository

class GetLatestAirFilterChangeUseCase(private val exploitationPartChangeRepository: ExploitationPartChangeRepository) {

    suspend fun execute() = exploitationPartChangeRepository.getLatestAirFilterChange()

}