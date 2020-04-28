package com.olehmesh.randomusers_task.di.module

import com.olehmesh.randomusers_task.adapters.UsersAdapter
import com.olehmesh.randomusers_task.di.scope.AppScope
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