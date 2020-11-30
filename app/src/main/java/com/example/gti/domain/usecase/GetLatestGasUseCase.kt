package com.example.gti.domain.usecase

import com.example.gti.data.db.model.Gas
import com.example.gti.domain.repository.GasRepository

class GetLatestGasUseCase(private val gasRepository: GasRepository) {

    suspend fun execute(): Gas? = gasRepository.getLatestGas()

}