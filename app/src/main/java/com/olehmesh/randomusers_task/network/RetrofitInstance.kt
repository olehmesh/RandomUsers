package com.olehmesh.randomusers_task.network

import com.olehmesh.randomusers_task.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private var retrofit: Retrofit? = null
    private var iRandUsers: IRandUsers? = null

    val client: IRandUsers?
        get() {

            if (iRandUsers == null) {

                retrofit = Retrofit.Builder()

                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

                iRandUsers = retrofit!!.create(IRandUsers::class.java)


            }


            return iRandUsers


        }
}
