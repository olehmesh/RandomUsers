package com.olehmesh.randomusers.di.module

import com.olehmesh.randomusers.presentation.adapters.UsersAdapter
import com.olehmesh.randomusers.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @AppScope
    @Provides
    fun provideUsersAdapter(): UsersAdapter {
        return UsersAdapter()
    }

}