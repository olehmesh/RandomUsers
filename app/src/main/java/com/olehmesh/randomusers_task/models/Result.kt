package com.olehmesh.randomusers_task.models

import android.graphics.drawable.Drawable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.olehmesh.randomusers_task.custom_views.CustomImageView


class Result {

    @SerializedName("name")
    @Expose
    var name: Name? = null

    @SerializedName("location")
    @Expose
    var location: Location? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("phone")
    @Expose
    var phone: String? = null

    @SerializedName("picture")
    @Expose
    var picture: Picture? = null

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
