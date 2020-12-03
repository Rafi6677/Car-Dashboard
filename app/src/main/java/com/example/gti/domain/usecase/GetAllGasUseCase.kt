package com.example.gti.domain.usecase

import com.example.gti.data.db.model.Gas
import com.example.gti.domain.repository.GasRepository

class GetAllGasUseCase(private val gasRepository: GasRepository) {

    suspend fun execute(): List<Gas>? = gasRepository.getAllGas()

}