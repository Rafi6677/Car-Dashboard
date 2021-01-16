package com.example.gti.domain.usecase

import com.example.gti.data.db.model.ExploitationPartChange
import com.example.gti.domain.repository.ExploitationPartChangeRepository

class GetLatestOilFilterChangeUseCase(private val exploitationPartChangeRepository: ExploitationPartChangeRepository) {

    suspend fun execute() = exploitationPartChangeRepository.getLatestOilFilterChange()

}