package com.example.gti.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gti.db.dao.*
import com.example.gti.db.model.*

@Database(entities = [
        CarInsurance::class,
        CarReview::class,
        Gas::class,
        OilChange::class,
        OilCheck::class
    ],
    version = 1,
    exportSchema = false
)
abstract class GtiDatabase : RoomDatabase() {

    abstract val carInsuranceDAO: CarInsuranceDAO
    abstract val carReviewDAO: CarReviewDAO
    abstract val gasDAO: GasDAO
    abstract val oilChangeDAO: OilChangeDAO
    abstract val oilCheckDAO: OilCheckDAO

    companion object {
        @Volatile
        private var INSTANCE: GtiDatabase ?= null

        fun getInstance(context: Context): GtiDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GtiDatabase::class.java,
                        "gti_database"
                    ).build()
                }

                return instance
            }
        }
    }

}