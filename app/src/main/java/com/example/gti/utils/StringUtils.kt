package com.example.gti.utils

import android.annotation.SuppressLint
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

object StringUtils {

    fun getStringFromDouble(double: Double): String {
        return BigDecimal(double)
            .setScale(2, RoundingMode.HALF_UP)
            .toString()
    }

    @SuppressLint("SimpleDateFormat")
    fun formatDateFromTimestampToString(timestamp: Long): String {
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        val date = Date(timestamp)

        return formatter.format(date)
    }

}