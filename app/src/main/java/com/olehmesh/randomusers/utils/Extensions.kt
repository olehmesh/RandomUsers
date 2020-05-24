package com.olehmesh.randomusers.utils

import android.graphics.drawable.Drawable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.olehmesh.randomusers.presentation.custom_views.ImageRoundCorners
import de.hdodenhof.circleimageview.CircleImageView


@BindingAdapter("picture", "errorImage")
fun ImageRoundCorners.loadImage(
    imageURL: String?,
    errorImage: Drawable
) {
    Glide.with(context)
        .load(imageURL)
        .apply(RequestOptions().encodeQuality(100))
        .placeholder(errorImage)
        .error(errorImage)
        .into(this)
}


@BindingAdapter("image", "errorImage")
fun CircleImageView.loadSaveImage(imageURL: String?, errorImage: Drawable) {
    Glide.with(context)
        .load(imageURL)
        .apply(RequestOptions().encodeQuality(100))
        .placeholder(errorImage)
        .error(errorImage)
        .into(this)

}





