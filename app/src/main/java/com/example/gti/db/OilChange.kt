package com.example.gti.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "oil_change_features")
data class OilChange(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "last_oil_change_mileage")
    val lastOilChangeMileage: Int,

    @ColumnInfo(name = "last_oil_change_timestamp")
    val lastOilChangeDate: Date

)