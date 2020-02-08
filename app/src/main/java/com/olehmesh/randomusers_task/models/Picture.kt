package com.olehmesh.randomusers_task.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Picture {

    @SerializedName("large")
    @Expose
    var large: String? = null

}
