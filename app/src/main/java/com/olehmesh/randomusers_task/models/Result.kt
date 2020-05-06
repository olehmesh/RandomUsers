package com.olehmesh.randomusers_task.models

import android.graphics.drawable.Drawable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName
import com.olehmesh.randomusers_task.custom_views.CustomImageView


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
) {

    companion object {
        @BindingAdapter("picture", "errorImage")
        @JvmStatic
        fun loadImage(imageView: CustomImageView, imageURL: String?, errorImage: Drawable) {
            Glide.with(imageView.context)
                .load(imageURL)
                .apply(RequestOptions().encodeQuality(100))
                .placeholder(errorImage)
                .error(errorImage)
                .into(imageView)
        }
    }

}