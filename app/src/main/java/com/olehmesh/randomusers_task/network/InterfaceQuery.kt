package com.olehmesh.randomusers_task.network

import com.olehmesh.randomusers_task.Constants
import com.olehmesh.randomusers_task.models.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface InterfaceQuery {

    @GET(Constants.GET_API)
    suspend fun fetchUsers(
        @Query("limit") loadSize: Int = 30,
        @Query("after") after: Int = 30,
        @Query("before") before: Int = 30
    ): Response<ApiResponse>

}
