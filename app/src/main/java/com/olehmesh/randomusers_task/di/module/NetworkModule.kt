package com.olehmesh.randomusers_task.di.module

import com.olehmesh.randomusers_task.network.ApiInstance
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun retrofitInstance(): ApiInstance {
        return ApiInstance
    }
}