package com.olehmesh.randomusers.database.dao

import androidx.room.*
import com.olehmesh.randomusers.database.entity.UserInfo

@Dao
interface DaoUserInfo {

    @get:Query("SELECT parent_id, date_current from table_date")
    // fun getDateAndInfo(): List<DateAndInfo>
    val getDateAndInfo: List<DateAndInfo>

    @get:Query("SELECT * FROM table_info")
    val all: List<UserInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entityDatabase: UserInfo)

    @Delete
    fun delete(entityDatabase: UserInfo)


}