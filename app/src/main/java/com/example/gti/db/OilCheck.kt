package com.example.gti.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "oil_level_features")
data class OilCheck(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "oil_percentage_level")
    val oilPercentageLevel: Int,

    @ColumnInfo(name = "current_car_mileage")
    val currentCarMileage: Int,

    @ColumnInfo(name = "oil_check_date")
    val timestamp: Date

)