package com.example.gti.presentation.di.core

import com.example.gti.data.db.dao.*
import com.example.gti.data.repository.datasource.*
import com.example.gti.data.repository.datasourceimpl.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideCarInsuranceDataSource(carInsuranceDAO: CarInsuranceDAO): CarInsuranceDataSource {
        return CarInsuranceDataSourceImpl(carInsuranceDAO)
    }

    @Singleton
    @Provides
    fun provideCarReviewDataSource(carReviewDAO: CarReviewDAO): CarReviewDataSource {
        return CarReviewDataSourceImpl(carReviewDAO)
    }

    @Singleton
    @Provides
    fun provideGasDataSource(gasDAO: GasDAO): GasDataSource {
        return GasDataSourceImpl(gasDAO)
    }

    @Singleton
    @Provides
    fun provideOilChangeDataSource(oilChangeDAO: OilChangeDAO): OilChangeDataSource {
        return OilChangeDataSourceImpl(oilChangeDAO)
    }

    @Singleton
    @Provides
    fun provideOilCheckDataSource(oilCheckDAO: OilCheckDAO): OilCheckDataSource {
        return OilCheckDataSourceImpl(oilCheckDAO)
    }

}