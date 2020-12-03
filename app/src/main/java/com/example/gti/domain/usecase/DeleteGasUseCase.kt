package com.example.gti.domain.usecase

import com.example.gti.data.db.model.Gas
import com.example.gti.domain.repository.GasRepository

class DeleteGasUseCase(private val gasRepository: GasRepository) {

    suspend fun execute(gas: Gas) = gasRepository.deleteGas(gas)

}