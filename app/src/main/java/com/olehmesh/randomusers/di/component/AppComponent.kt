package com.olehmesh.randomusers.di.component

import com.olehmesh.randomusers.presentation.adapters.UsersAdapter
import com.olehmesh.randomusers.di.module.AdapterModule
import com.olehmesh.randomusers.di.module.NetworkModule
import com.olehmesh.randomusers.di.module.NavModule
import com.olehmesh.randomusers.di.module.StorageModule
import com.olehmesh.randomusers.di.scope.ApiScope
import com.olehmesh.randomusers.domain.RoomViewModel
import com.olehmesh.randomusers.presentation.fragments.MainFragment
import com.olehmesh.randomusers.presentation.fragments.SavedFragment
import com.olehmesh.randomusers.repository.ItemKeyedSource
import dagger.Component

@ApiScope
@Component(modules = [StorageModule::class, NetworkModule::class, AdapterModule::class, NavModule::class])
interface AppComponent {

    fun inject(application: MainFragment)

    fun inject(application: UsersAdapter)

    fun inject(itemKeyedSource: ItemKeyedSource)

    fun inject(roomViewModel: RoomViewModel)

    fun inject(savedFragment: SavedFragment)

    fun createDetailComponent(): DetailComponent

}