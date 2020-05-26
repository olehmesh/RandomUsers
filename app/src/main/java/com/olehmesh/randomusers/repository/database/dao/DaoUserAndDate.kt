package com.olehmesh.randomusers.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.olehmesh.randomusers.repository.database.entity.DateLatLng
import com.olehmesh.randomusers.repository.database.entity.UserEntity
import com.olehmesh.randomusers.repository.database.relation.DateAndUser

@Dao
interface DaoUserAndDate {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserInfo(userEntity: UserEntity?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentDate(dateLatLng: DateLatLng?)

    @Transaction
    fun insertUserAndDate(userEntity: UserEntity?, dateLatLng: DateLatLng?) {
        insertCurrentDate(dateLatLng)
        insertUserInfo(userEntity)
    }

    @Transaction
    @Query("SELECT * FROM table_date_lat_lng")
    fun getDateAndUsers(): LiveData<MutableList<DateAndUser>>

}


