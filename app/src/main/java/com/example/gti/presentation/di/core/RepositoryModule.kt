package com.example.gti.presentation.di.core

import com.example.gti.data.repository.*
import com.example.gti.data.repository.datasource.*
import com.example.gti.domain.repository.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideCarInsuranceRepository(carInsuranceDataSource: CarInsuranceDataSource): CarInsuranceRepository {
        return CarInsuranceRepositoryImpl(carInsuranceDataSource)
    }

    @Singleton
    @Provides
    fun provideCarReviewRepository(carReviewDataSource: CarReviewDataSource): CarReviewRepository {
        return CarReviewRepositoryImpl(carReviewDataSource)
    }

    @Singleton
    @Provides
    fun provideGasRepository(gasDataSource: GasDataSource): GasRepository {
        return GasRepositoryImpl(gasDataSource)
    }

    @Singleton
    @Provides
    fun provideFiltersChangeRepository(filtersChangeDataSource: FiltersChangeDataSource): FiltersChangeRepository {
        return FiltersChangeRepositoryImpl(filtersChangeDataSource)
    }

    @Singleton
    @Provides
    fun provideOilCheckRepository(oilCheckDataSource: OilCheckDataSource): OilCheckRepository {
        return OilCheckRepositoryImpl(oilCheckDataSource)
    }

}