package com.example.gti.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "oil_level_features")
data class OilCheck(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "oil_percentage_level")
    val oilPercentageLevel: Int,

    @ColumnInfo(name = "current_car_mileage")
    val currentCarMileage: Int,

    @ColumnInfo(name = "last_oil_check_timestamp")
    val oilCheckTimestamp: Long

)