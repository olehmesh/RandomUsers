package com.olehmesh.randomusers_task.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ApiResponse {

    @SerializedName("results")
    @Expose
    var results: List<Result>? = null
    @SerializedName("info")
    @Expose
    var info: Info? = null

}