package com.example.gti.domain.usecase

import com.example.gti.domain.repository.GasRepository

class GetAllGasUseCase(private val gasRepository: GasRepository) {

    fun execute() = gasRepository.getAllGas()

}