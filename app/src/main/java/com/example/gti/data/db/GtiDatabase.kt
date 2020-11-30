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

    abstract val carInsuranceDAO: CarInsuranceDAO
    abstract val carReviewDAO: CarReviewDAO
    abstract val gasDAO: GasDAO
    abstract val oilChangeDAO: OilChangeDAO
    abstract val oilCheckDAO: OilCheckDAO

}