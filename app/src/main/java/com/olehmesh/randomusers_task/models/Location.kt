package com.olehmesh.randomusers_task.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Location {

    @SerializedName("street")
    @Expose
    var street: String? = null
    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("state")
    @Expose
    var state: String? = null
    @SerializedName("postcode")
    @Expose
    var postcode: String? = null

}
