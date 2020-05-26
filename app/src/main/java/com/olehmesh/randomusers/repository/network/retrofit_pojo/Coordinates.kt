package com.olehmesh.randomusers.repository.network.retrofit_pojo

import com.google.gson.annotations.SerializedName

data class Coordinates(

    @SerializedName("latitude")
    var latitude: String? = null,

    @SerializedName("longitude")
    var longitude: String? = null

)