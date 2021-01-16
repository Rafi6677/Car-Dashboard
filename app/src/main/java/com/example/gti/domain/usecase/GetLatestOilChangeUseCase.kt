package com.example.gti.domain.usecase

import com.example.gti.domain.repository.ExploitationPartChangeRepository

class GetLatestOilChangeUseCase(private val exploitationPartChangeRepository: ExploitationPartChangeRepository) {

    suspend fun execute() = exploitationPartChangeRepository.getLatestOilChange()

}