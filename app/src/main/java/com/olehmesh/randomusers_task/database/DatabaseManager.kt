package com.olehmesh.randomusers_task.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.olehmesh.randomusers_task.database.dao.DaoCurrentDate
import com.olehmesh.randomusers_task.database.dao.DaoUserAndDate
import com.olehmesh.randomusers_task.database.dao.DaoUserInfo
import com.olehmesh.randomusers_task.database.entity.DateCurrent
import com.olehmesh.randomusers_task.database.entity.UserInfo

@Database(entities = [UserInfo::class, DateCurrent::class], version = 1, exportSchema = false)

abstract class DatabaseManager : RoomDatabase() {

    abstract fun daoUserInfo(): DaoUserInfo
    abstract fun daoCurrentDate(): DaoCurrentDate
    abstract fun daoUserAndDate(): DaoUserAndDate


    companion object {
        @Volatile
        private var DB_INSTANCE: DatabaseManager? = null

        fun getDatabase(context: Context?): DatabaseManager? {

            if (DB_INSTANCE == null) {
                synchronized(DatabaseManager::class) {
                    DB_INSTANCE =
                        Room.databaseBuilder(context!!.applicationContext, DatabaseManager::class.java, "db_rand_users")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return DB_INSTANCE

        }

    }


}