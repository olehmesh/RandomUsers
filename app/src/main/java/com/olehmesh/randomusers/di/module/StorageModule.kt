package com.olehmesh.randomusers.di.module

import android.app.Application
import androidx.room.Room
import com.olehmesh.randomusers.di.scope.ApiScope
import com.olehmesh.randomusers.repository.database.DatabaseManager
import com.olehmesh.randomusers.repository.database.dao.DaoUserAndDate
import com.olehmesh.randomusers.repository.database.dao.DaoUserEntity
import dagger.Module
import dagger.Provides


@Module
class StorageModule(var application: Application) {

    lateinit var db: DatabaseManager

    @ApiScope
    @Provides
    fun provideContext(): Application {
        return application
    }


    @ApiScope
    @Provides
    fun provideDatabase(): DatabaseManager {

        db = Room.databaseBuilder(application, DatabaseManager::class.java, "db_rand_users")
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



