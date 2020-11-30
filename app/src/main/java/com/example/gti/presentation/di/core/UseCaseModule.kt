package com.example.gti.presentation.di.core

import com.example.gti.domain.repository.*
import com.example.gti.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetLatestCarInsuranceUseCase(carInsuranceRepository: CarInsuranceRepository): GetLatestCarInsuranceUseCase {
        return GetLatestCarInsuranceUseCase(carInsuranceRepository)
    }

    @Provides
    fun provideGetLatestCarReviewUseCase(carReviewRepository: CarReviewRepository): GetLatestCarReviewUseCase {
        return GetLatestCarReviewUseCase(carReviewRepository)
    }

    @Provides
    fun provideGetLatestGasUseCase(gasRepository: GasRepository): GetLatestGasUseCase {
        return GetLatestGasUseCase(gasRepository)
    }

    @Provides
    fun provideGetLatestOilChangeUseCase(oilChangeRepository: OilChangeRepository): GetLatestOilChangeUseCase {
        return GetLatestOilChangeUseCase(oilChangeRepository)
    }

    @Provides
    fun provideGetLatestOilCheckUseCase(oilCheckRepository: OilCheckRepository): GetLatestOilCheckUseCase {
        return GetLatestOilCheckUseCase(oilCheckRepository)
    }

}