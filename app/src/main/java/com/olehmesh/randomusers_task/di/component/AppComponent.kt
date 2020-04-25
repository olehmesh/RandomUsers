package com.olehmesh.randomusers_task.di.component

import com.olehmesh.randomusers_task.di.module.AdapterModule
import com.olehmesh.randomusers_task.di.module.ApiModule
import com.olehmesh.randomusers_task.di.module.StorageModule
import com.olehmesh.randomusers_task.di.scope.AppScope
import com.olehmesh.randomusers_task.views.MainFragment
import dagger.Component

@AppScope
@Component(modules = [StorageModule::class, ApiModule::class, AdapterModule::class])
interface AppComponent {

    fun inject(application: MainFragment)

}