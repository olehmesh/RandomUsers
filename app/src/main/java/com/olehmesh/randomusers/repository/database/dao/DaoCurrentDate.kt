package com.olehmesh.randomusers.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.olehmesh.randomusers.repository.database.entity.DateCurrent
import com.olehmesh.randomusers.repository.database.entity.UserEntity

@Dao
interface DaoCurrentDate {

    @get:Query("SELECT * FROM `table_date`")
    val currentDate: LiveData<MutableList<DateCurrent>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentDate(dateCurrent: DateCurrent)

}