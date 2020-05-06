package com.olehmesh.randomusers.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.olehmesh.randomusers.BuildConfig
import com.olehmesh.randomusers.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiInstance {

    private var retrofit: Retrofit? = null
    private var interfaceQuery: InterfaceQuery? = null

    val client: InterfaceQuery?
        get() {

            if (interfaceQuery == null) {

                val interceptor = HttpLoggingInterceptor()
                interceptor.level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE

                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()

                retrofit = Retrofit.Builder()

                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .client(okHttpClient)
                    .build()

                interfaceQuery = retrofit!!.create(InterfaceQuery::class.java)

            }

            return interfaceQuery
        }

}
