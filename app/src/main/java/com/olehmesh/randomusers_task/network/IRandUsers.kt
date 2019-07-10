package com.olehmesh.randomusers_task.network

import com.olehmesh.randomusers_task.Constants
import com.olehmesh.randomusers_task.models.ApiResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IRandUsers {

    @GET(Constants.GET_API)
    fun fetchUsers(@Query("results") results: Int): Single<ApiResponse>

}
