package com.example.gti.domain.usecase

import com.example.gti.domain.repository.FiltersChangeRepository

class GetLatestOilFilterChangeUseCase(private val filtersChangeRepository: FiltersChangeRepository) {

    suspend fun execute() = filtersChangeRepository.getLatestOilFilterChange()

}