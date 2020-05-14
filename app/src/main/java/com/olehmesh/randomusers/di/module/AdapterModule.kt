package com.olehmesh.randomusers.di.module

import com.olehmesh.randomusers.presentation.adapters.UsersAdapter
import com.olehmesh.randomusers.di.scope.ApiScope
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @ApiScope
    @Provides
    fun provideUsersAdapter(): UsersAdapter {
        return UsersAdapter()
    }

}