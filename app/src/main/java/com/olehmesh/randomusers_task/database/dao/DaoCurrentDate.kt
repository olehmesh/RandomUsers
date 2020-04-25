package com.olehmesh.randomusers_task.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olehmesh.randomusers_task.database.entity.DateCurrent
import com.olehmesh.randomusers_task.database.entity.UserInfo

@Dao
interface DaoCurrentDate {

    @get:Query("SELECT * FROM `table_date`")
    val all: List<DateCurrent>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentDate(dateCurrent: DateCurrent)

}