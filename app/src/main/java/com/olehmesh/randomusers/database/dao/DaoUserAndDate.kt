package com.olehmesh.randomusers.database.dao

import androidx.room.*
import com.olehmesh.randomusers.database.entity.DateCurrent
import com.olehmesh.randomusers.database.entity.UserInfo


@Dao
abstract class DaoUserAndDate {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUserInfo(userInfo: UserInfo?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCurrentDate(dateCurrent: DateCurrent?)

    @Transaction
    open fun insertUserAndDate(userInfo: UserInfo?, dateCurrent: DateCurrent?) {
        insertCurrentDate(dateCurrent)
        insertUserInfo(userInfo)
    }
}