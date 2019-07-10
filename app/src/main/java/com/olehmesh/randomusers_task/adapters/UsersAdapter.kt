package com.olehmesh.randomusers_task.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.olehmesh.randomusers_task.R
import com.olehmesh.randomusers_task.models.Result
import com.olehmesh.randomusers_task.views.DetailActivity

class UsersAdapter(var mlist: List<Result>?) : RecyclerView.Adapter<ItemViewHolder>() {

    lateinit var intent: Intent

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(v)
    }

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, i: Int) {
        itemViewHolder.list = mlist!![i]

        itemViewHolder.tvName.text = mlist!![i].name!!.first
        itemViewHolder.tvCity.text = mlist!![i].location!!.city

        Glide.with(itemViewHolder.itemView.context)
            .asBitmap()
            .load(mlist!![i].picture!!.large)
            .apply(
                RequestOptions()
                    .override(Target.SIZE_ORIGINAL).encodeQuality(100)
            )
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(itemViewHolder.ivAvatar)

        itemViewHolder.setOnItemClickListener { view, position, isLongClick ->

            intent = Intent(view.context, DetailActivity::class.java)
            intent.putExtra(R.string.name.toString(), mlist!![i].name!!.first)
            intent.putExtra(R.string.city.toString(), mlist!![i].location!!.city)

            intent.putExtra(R.string.image.toString(), mlist!![position].picture!!.large)

            intent.putExtra(R.string.email.toString(), mlist!![position].email)
            intent.putExtra(R.string.phone.toString(), mlist!![position].phone)

            view.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return if (mlist == null) {
            0
        } else mlist!!.size
    }

    fun setData(mlist: List<Result>) {
        this.mlist = mlist
        notifyDataSetChanged()
    }
}