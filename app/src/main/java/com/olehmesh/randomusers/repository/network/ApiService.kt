package com.olehmesh.randomusers.repository.network

import com.olehmesh.randomusers.repository.network.retrofit_pojo.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/?inc=name,location,email,dob,phone,picture")
    suspend fun fetchUsers(
        @Query("limit") loadSize: Int = 30,
        @Query("after") after: Int = 20,
        @Query("before") before: Int = 20
    ): Response<ApiResponse>

}
