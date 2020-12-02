package com.example.gti.data.db.dao

import androidx.room.*
import com.example.gti.data.db.model.CarInsurance

@Dao
interface CarInsuranceDAO {

    @Insert
    suspend fun insertCarInsuranceData(carInsurance: CarInsurance): Long

    @Update
    suspend fun updateCarInsuranceData(carInsurance: CarInsurance): Int

    @Delete
    suspend fun deleteCarInsuranceData(carInsurance: CarInsurance): Int

    @Query("DELETE FROM car_insurance")
    suspend fun deleteAllCarInsuranceData(): Int

    @Query("SELECT * FROM car_insurance")
    suspend fun getAllCarInsuranceData(): List<CarInsurance>

    @Query("SELECT * FROM car_insurance WHERE car_insurance_timestamp = (SELECT MAX(car_insurance_timestamp) FROM car_insurance)")
    suspend fun getLatestCarInsuranceData(): CarInsurance

}