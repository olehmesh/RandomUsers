package com.olehmesh.randomusers.repository.network.retrofit_pojo

import com.google.gson.annotations.SerializedName

data class Location(

    @SerializedName("city")
    var city: String? = null,

    @SerializedName("coordinates")
    var coordinates: Coordinates? = null

)
