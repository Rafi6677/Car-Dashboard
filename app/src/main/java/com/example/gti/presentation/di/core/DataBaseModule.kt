package com.example.gti.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.gti.data.db.GtiDatabase
import com.example.gti.data.db.dao.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDataBase(context: Context): GtiDatabase {
        return Room.databaseBuilder(
            context,
            GtiDatabase::class.java,
            "gti_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCarInsuranceDAO(gtiDatabase: GtiDatabase): CarInsuranceDAO {
        return gtiDatabase.carInsuranceDAO
    }

    @Singleton
    @Provides
    fun provideCarReviewDAO(gtiDatabase: GtiDatabase): CarReviewDAO {
        return gtiDatabase.carReviewDAO
    }

    @Singleton
    @Provides
    fun provideGasDAO(gtiDatabase: GtiDatabase): GasDAO {
        return gtiDatabase.gasDAO
    }

    @Singleton
    @Provides
    fun provideOilChangeDAO(gtiDatabase: GtiDatabase): OilChangeDAO {
        return gtiDatabase.oilChangeDAO
    }

    @Singleton
    @Provides
    fun provideOilCheckDAO(gtiDatabase: GtiDatabase): OilCheckDAO {
        return gtiDatabase.oilCheckDAO
    }

}