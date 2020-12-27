package com.example.gti.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "filters_change")
data class FiltersChange(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "oil_name_info")
    val oilNameInfo: String,

    @ColumnInfo(name = "last_oil_change_mileage")
    val lastOilChangeMileage: Int,

    @ColumnInfo(name = "last_oil_change_timestamp")
    val lastOilChangeTimestamp: Long,

    @ColumnInfo(name = "last_oil_filter_change_mileage")
    val lastOilFilterChangeMileage: Int,

    @ColumnInfo(name = "last_oil_filter_change_timestamp")
    val lastOilFilterChangeTimestamp: Long,

    @ColumnInfo(name = "last_air_filter_change_mileage")
    val lastAirFilterChangeMileage: Int,

    @ColumnInfo(name = "last_air_filter_change_timestamp")
    val lastAirFilterChangeTimestamp: Long,

    @ColumnInfo(name = "last_cabin_filter_change_mileage")
    val lastCabinFilterChangeMileage: Int,

    @ColumnInfo(name = "last_cabin_filter_change_timestamp")
    val lastCabinFilterChangeTimestamp: Long

)