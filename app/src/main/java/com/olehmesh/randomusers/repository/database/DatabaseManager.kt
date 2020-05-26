package com.olehmesh.randomusers.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.olehmesh.randomusers.repository.database.dao.DaoCurrentDate
import com.olehmesh.randomusers.repository.database.dao.DaoUserAndDate
import com.olehmesh.randomusers.repository.database.dao.DaoUserEntity
import com.olehmesh.randomusers.repository.database.entity.DateLatLng
import com.olehmesh.randomusers.repository.database.entity.UserEntity

@Database(entities = [UserEntity::class, DateLatLng::class], version = 1, exportSchema = false)
abstract class DatabaseManager : RoomDatabase() {

    abstract fun daoUserInfo(): DaoUserEntity
    abstract fun daoCurrentDate(): DaoCurrentDate
    abstract fun daoUserAndDate(): DaoUserAndDate

}