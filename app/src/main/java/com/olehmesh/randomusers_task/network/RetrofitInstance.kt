package com.olehmesh.randomusers_task.network

import com.olehmesh.randomusers_task.BuildConfig
import com.olehmesh.randomusers_task.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    private var retrofit: Retrofit? = null
    private var iRandUsers: IRandUsers? = null

    val client: IRandUsers?
        get() {

            if (iRandUsers == null) {

                val interceptor = HttpLoggingInterceptor()
                interceptor.level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

                retrofit = Retrofit.Builder()

                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

                iRandUsers = retrofit!!.create(IRandUsers::class.java)

            }

            return iRandUsers
        }

}
