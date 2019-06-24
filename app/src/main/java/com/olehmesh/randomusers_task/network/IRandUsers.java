package com.olehmesh.randomusers_task.network;

import com.olehmesh.randomusers_task.models.ApiResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IRandUsers {

    @GET("api/?inc=name,location,picture,phone,email")

    Single<ApiResponse> fetchUsers(@Query("results") int results);

}
