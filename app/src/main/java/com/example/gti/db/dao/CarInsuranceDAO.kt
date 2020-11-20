package com.example.gti.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gti.db.model.CarInsurance

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
    fun getAllCarInsuranceData(): LiveData<List<CarInsurance>>

    @Query("SELECT * FROM car_insurance WHERE car_insurance_timestamp = (SELECT MAX(car_insurance_timestamp) FROM car_insurance)")
    fun getLatestCarInsuranceData(): LiveData<CarInsurance>

}