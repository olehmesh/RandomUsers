package com.olehmesh.randomusers.repository.database.dao

import androidx.room.*
import com.olehmesh.randomusers.repository.database.entity.DateCurrent
import com.olehmesh.randomusers.repository.database.entity.UserEntity


@Dao
abstract class DaoUserAndDate {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUserInfo(userEntity: UserEntity?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCurrentDate(dateCurrent: DateCurrent?)

    @Transaction
    open fun insertUserAndDate(userEntity: UserEntity?, dateCurrent: DateCurrent?) {
        insertCurrentDate(dateCurrent)
        insertUserInfo(userEntity)
    }
}