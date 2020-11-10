package com.example.gti.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "gas_features")
data class Gas(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "gas_travel_distance")
    val travelDistance: Double,

    @ColumnInfo(name = "gas_liters_consumed")
    val litersConsumed: Double,

    @ColumnInfo(name = "gas_price")
    val gasPrice: Double,

    @ColumnInfo(name = "last_refueling_date")
    val lastRefuelingDate: Date

)