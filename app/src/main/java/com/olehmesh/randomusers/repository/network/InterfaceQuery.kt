package com.olehmesh.randomusers.repository.network

import com.olehmesh.randomusers.repository.retrofit_pojo.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface InterfaceQuery {

    @GET("api/?inc=name,location,email,phone,picture")
    suspend fun fetchUsers(
        @Query("limit") loadSize: Int = 30,
        @Query("after") after: Int = 30,
        @Query("before") before: Int = 30
    ): Response<ApiResponse>

}
