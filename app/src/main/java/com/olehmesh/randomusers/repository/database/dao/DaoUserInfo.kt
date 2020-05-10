package com.olehmesh.randomusers.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.olehmesh.randomusers.repository.database.entity.UserEntity

@Dao
interface DaoUserInfo {

    // @get:Query("SELECT parent_id, date_current from table_date")
    // fun getDateAndInfo(): List<DateAndInfo>
    // val getDateAndInfo: List<DateAndInfo>

    @get:Query("SELECT * FROM table_info")
    val all: LiveData<MutableList<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entityDatabase: UserEntity)

    @Delete
    fun delete(entityDatabase: UserEntity)


}