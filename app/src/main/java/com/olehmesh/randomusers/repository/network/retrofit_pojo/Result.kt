package com.olehmesh.randomusers.repository.network.retrofit_pojo

import com.google.gson.annotations.SerializedName


data class Result(

    @SerializedName("name")
    var name: Name? = null,

    @SerializedName("location")
    var location: Location? = null,

    @SerializedName("email")
    var email: String? = null,

    @SerializedName("phone")
    var phone: String? = null,

    @SerializedName("picture")
    var picture: Picture? = null
)