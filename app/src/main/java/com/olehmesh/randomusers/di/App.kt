package com.olehmesh.randomusers.di

import android.app.Application
import com.olehmesh.randomusers.di.component.AppComponent
import com.olehmesh.randomusers.di.component.DaggerAppComponent

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