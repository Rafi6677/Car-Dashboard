package com.example.gti.domain.usecase

import com.example.gti.domain.repository.ExploitationPartChangeRepository

class GetLatestCabinFilterChangeUseCase(private val exploitationPartChangeRepository: ExploitationPartChangeRepository) {

    suspend fun execute() = exploitationPartChangeRepository.getLatestCabinFilterChange()

}