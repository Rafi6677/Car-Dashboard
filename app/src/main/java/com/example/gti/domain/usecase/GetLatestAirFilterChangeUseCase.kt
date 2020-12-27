package com.example.gti.domain.usecase

import com.example.gti.domain.repository.FiltersChangeRepository

class GetLatestAirFilterChangeUseCase(private val filtersChangeRepository: FiltersChangeRepository) {

    suspend fun execute() = filtersChangeRepository.getLatestAirFilterChange()

}