package com.olehmesh.randomusers.repository.network.retrofit_pojo

import com.google.gson.annotations.SerializedName


data class Result(

    @SerializedName("name")
    var name: Name?,

    @SerializedName("location")
    var location: Location?,

    @SerializedName("email")
    var email: String?,

    @SerializedName("phone")
    var phone: String?,

    @SerializedName("picture")
    var picture: Picture?,

    @SerializedName("dob")
    var dob: Dob?
)
