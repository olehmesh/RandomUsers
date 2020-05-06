package com.olehmesh.randomusers.di.module

import androidx.room.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class StorageModule {

    @Provides
    @Singleton
    fun provideDatabase(): Database? {

        return provideDatabase()

    }
}



