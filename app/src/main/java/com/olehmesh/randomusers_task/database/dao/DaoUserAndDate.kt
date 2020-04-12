package com.olehmesh.randomusers_task.database.dao

import androidx.room.*
import com.olehmesh.randomusers_task.database.entity.DateCurrent
import com.olehmesh.randomusers_task.database.entity.UserInfo


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