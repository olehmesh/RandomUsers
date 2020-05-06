package com.olehmesh.randomusers_task.di

import android.app.Application
import com.olehmesh.randomusers_task.di.component.AppComponent
import com.olehmesh.randomusers_task.di.component.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.create()
    }

    /*  fun getAppComponent(): AppComponent {
          return component
      } */
}