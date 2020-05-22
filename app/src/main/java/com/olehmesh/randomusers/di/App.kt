package com.olehmesh.randomusers.di

import android.app.Application
import androidx.room.Room
import com.olehmesh.randomusers.di.component.AppComponent
import com.olehmesh.randomusers.di.component.DaggerAppComponent
import com.olehmesh.randomusers.di.module.AdapterModule_ProvideUsersAdapterFactory.create
import com.olehmesh.randomusers.di.module.NetworkModule
import com.olehmesh.randomusers.di.module.StorageModule
import com.olehmesh.randomusers.di.module.StorageModule_ProvideDatabaseFactory.create
import com.olehmesh.randomusers.repository.database.DatabaseManager

class App : Application() {

    companion object {

        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .storageModule(StorageModule(this))
            .build()
    }

}