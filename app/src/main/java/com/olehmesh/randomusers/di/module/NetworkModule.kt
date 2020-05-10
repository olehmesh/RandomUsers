package com.olehmesh.randomusers.di.module

import com.olehmesh.randomusers.repository.network.ApiInstance
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun retrofitInstance(): ApiInstance {
        return ApiInstance
    }
}