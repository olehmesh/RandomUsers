package com.olehmesh.randomusers.di.component

import com.olehmesh.randomusers.presentation.adapters.UsersAdapter
import com.olehmesh.randomusers.di.module.AdapterModule
import com.olehmesh.randomusers.di.module.NetworkModule
import com.olehmesh.randomusers.di.module.NavModule
import com.olehmesh.randomusers.di.module.StorageModule
import com.olehmesh.randomusers.di.scope.AppScope
import com.olehmesh.randomusers.presentation.fragments.MainFragment
import dagger.Component

@AppScope
@Component(modules = [StorageModule::class, NetworkModule::class, AdapterModule::class, NavModule::class])
interface AppComponent {

    fun inject(application: MainFragment)

    fun inject(application: UsersAdapter)

    fun createDetailComponent(): DetailComponent

}