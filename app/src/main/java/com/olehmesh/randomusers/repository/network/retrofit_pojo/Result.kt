package com.olehmesh.randomusers.repository.network.retrofit_pojo

import android.graphics.drawable.Drawable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName
import com.olehmesh.randomusers.presentation.custom_views.ImageRoundCorners

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
        fun loadImage(
            imageRoundCorners: ImageRoundCorners,
            imageURL: String?,
            errorImage: Drawable
        ) {
            Glide.with(imageRoundCorners.context)
                .load(imageURL)
                .apply(RequestOptions().encodeQuality(100))
                .placeholder(errorImage)
                .error(errorImage)
                .into(imageRoundCorners)
        }
    }

}