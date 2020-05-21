package com.olehmesh.randomusers.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.olehmesh.randomusers.repository.database.entity.UserEntity

@Dao
interface DaoUserEntity {

    @get:Query("SELECT * FROM table_info")
    val allUsersDB: LiveData<MutableList<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entityDatabase: UserEntity)

    @Delete
    fun delete(entityDatabase: UserEntity)

}