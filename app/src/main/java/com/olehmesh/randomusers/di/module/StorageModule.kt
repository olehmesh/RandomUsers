package com.olehmesh.randomusers.di.module

import android.content.Context
import androidx.room.Room
import com.olehmesh.randomusers.di.scope.ApiScope
import com.olehmesh.randomusers.repository.database.DatabaseManager
import com.olehmesh.randomusers.repository.database.dao.DaoUserAndDate
import com.olehmesh.randomusers.repository.database.dao.DaoUserEntity
import dagger.Module
import dagger.Provides


@Module
class StorageModule(var context: Context) {

    lateinit var db: DatabaseManager

    @ApiScope
    @Provides
    fun provideContext(): Context {
        return context
    }


    @ApiScope
    @Provides
    fun provideDatabase(): DatabaseManager {

        db = Room.databaseBuilder(context, DatabaseManager::class.java, "db_rand_users")
            .build()
        return db

    }


    @ApiScope
    @Provides
    fun provideUserAndDate(db: DatabaseManager): DaoUserAndDate {
        return db.daoUserAndDate()
    }

    @ApiScope
    @Provides
    fun provideUserAndDateDelete(db: DatabaseManager): DaoUserEntity {
        return db.daoUserInfo()
    }

}



