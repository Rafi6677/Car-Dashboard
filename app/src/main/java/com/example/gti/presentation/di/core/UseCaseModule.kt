package com.example.gti.presentation.di.core

import com.example.gti.domain.repository.*
import com.example.gti.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideDeleteGasUseCase(gasRepository: GasRepository): DeleteGasUseCase {
        return DeleteGasUseCase(gasRepository)
    }

    @Provides
    fun provideEditGasUseCase(gasRepository: GasRepository): EditGasUseCase {
        return EditGasUseCase(gasRepository)
    }

    @Provides
    fun provideGetAllGasUseCase(gasRepository: GasRepository): GetAllGasUseCase {
        return GetAllGasUseCase(gasRepository)
    }

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
    fun provideGetLatestOilChangeUseCase(filtersChangeRepository: FiltersChangeRepository): GetLatestOilChangeUseCase {
        return GetLatestOilChangeUseCase(filtersChangeRepository)
    }

    @Provides
    fun provideGetLatestOilCheckUseCase(oilCheckRepository: OilCheckRepository): GetLatestOilCheckUseCase {
        return GetLatestOilCheckUseCase(oilCheckRepository)
    }

    @Provides
    fun provideInsertGasUseCase(gasRepository: GasRepository): InsertGasUseCase {
        return InsertGasUseCase(gasRepository)
    }

}