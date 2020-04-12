package com.olehmesh.randomusers_task.di.component

import com.olehmesh.randomusers_task.di.App
import com.olehmesh.randomusers_task.di.module.StorageModule
import dagger.Component

@Component(modules = [StorageModule::class])
interface AppComponent {

    fun inject(application: App)

}