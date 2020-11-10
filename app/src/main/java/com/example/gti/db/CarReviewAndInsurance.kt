package com.example.gti.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "car_review_and_insurance")
data class CarReviewAndInsurance(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "car_review_date")
    val carReviewDate: Date,

    @ColumnInfo(name = "car_insurance_date")
    val carInsuranceDate: Date

)