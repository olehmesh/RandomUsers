package com.olehmesh.randomusers_task.database.dao

import androidx.room.*
import com.olehmesh.randomusers_task.database.entity.UserInfo

@Dao
interface DaoUserInfo {

    @get:Query("SELECT * FROM user_info")
    val all: List<UserInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entityDatabase: UserInfo)

    @Delete
    fun delete(entityDatabase: UserInfo)

}