package com.olehmesh.randomusers.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.olehmesh.randomusers.repository.database.entity.DateLatLng

@Dao
interface DaoCurrentDate {

    @get:Query("SELECT * FROM `table_date_lat_lng`")
    val currentDate: LiveData<MutableList<DateLatLng>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentDate(dateLatLng: DateLatLng)

}