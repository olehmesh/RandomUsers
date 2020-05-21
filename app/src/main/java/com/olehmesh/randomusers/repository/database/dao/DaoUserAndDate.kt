package com.olehmesh.randomusers.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.olehmesh.randomusers.repository.database.entity.DateCurrent
import com.olehmesh.randomusers.repository.database.entity.UserEntity
import com.olehmesh.randomusers.repository.database.relation.DateAndInfo

@Dao
interface DaoUserAndDate {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserInfo(userEntity: UserEntity?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentDate(dateCurrent: DateCurrent?)

    @Transaction
    fun insertUserAndDate(userEntity: UserEntity?, dateCurrent: DateCurrent?) {
        insertCurrentDate(dateCurrent)
        insertUserInfo(userEntity)
    }

    @Transaction
    @Query("SELECT * FROM table_date")
    fun getDateAndUsers(): LiveData<MutableList<DateAndInfo>>

}


