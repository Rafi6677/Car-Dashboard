package com.example.gti.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gti.data.db.dao.*
import com.example.gti.data.db.model.*

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

    abstract fun carInsuranceDAO(): CarInsuranceDAO
    abstract fun carReviewDAO(): CarReviewDAO
    abstract fun gasDAO(): GasDAO
    abstract fun oilChangeDAO(): OilChangeDAO
    abstract fun oilCheckDAO(): OilCheckDAO

}