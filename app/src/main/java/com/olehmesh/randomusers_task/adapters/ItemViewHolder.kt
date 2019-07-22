package com.olehmesh.randomusers_task.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.olehmesh.randomusers_task.R
import com.olehmesh.randomusers_task.models.Result
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.main_list_item.*

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    override val containerView: View?
        get() = itemView

    fun bind(item: Result) {

        tvFirstName.text = item.name!!.first
        tvCity.text = item.location!!.city

        Glide.with(itemView.context)
            .asBitmap()
            .load(item.picture!!.large)
            .apply(RequestOptions().override(Target.SIZE_ORIGINAL).encodeQuality(100))
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(ivAvatar)

    }

}