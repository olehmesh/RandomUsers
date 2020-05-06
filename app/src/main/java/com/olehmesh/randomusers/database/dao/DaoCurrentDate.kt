package com.olehmesh.randomusers.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olehmesh.randomusers.database.entity.DateCurrent

@Dao
interface DaoCurrentDate {

    @get:Query("SELECT * FROM `table_date`")
    val all: List<DateCurrent>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentDate(dateCurrent: DateCurrent)

}