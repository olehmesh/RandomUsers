package com.olehmesh.randomusers_task.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.olehmesh.randomusers_task.database.entity.DateCurrent

@Dao
interface DaoCurrentDate {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentDate(dateCurrent: DateCurrent)

}