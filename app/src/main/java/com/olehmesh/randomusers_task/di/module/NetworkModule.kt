package com.olehmesh.randomusers_task.di.module

import com.olehmesh.randomusers_task.BuildConfig
import com.olehmesh.randomusers_task.Constants
import com.olehmesh.randomusers_task.network.IRandUsers
import com.olehmesh.randomusers_task.network.RetrofitInstance
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun retrofitInstance(): RetrofitInstance {
        return RetrofitInstance
    }
}