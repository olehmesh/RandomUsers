package com.olehmesh.randomusers_task.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.olehmesh.randomusers_task.Constants
import com.olehmesh.randomusers_task.R
import com.olehmesh.randomusers_task.models.Result


class UsersAdapter(var mlist: List<Result>?) : RecyclerView.Adapter<ItemViewHolder>() {

    var context: Context? = null
    private lateinit var navController: NavController

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.main_list_item, parent, false)

        return ItemViewHolder(v)
    }

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, i: Int) {
        itemViewHolder.list = mlist!![i]

        itemViewHolder.tvName.text = mlist!![i].name!!.first
        itemViewHolder.tvCity.text = mlist!![i].location!!.city

        Glide.with(itemViewHolder.itemView.context)
            .asBitmap()
            .load(mlist!![i].picture!!.large)
            .apply(RequestOptions().override(Target.SIZE_ORIGINAL).encodeQuality(100))
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(itemViewHolder.ivAvatar)

        itemViewHolder.setOnItemClickListener { view, position ->

            navController = Navigation.findNavController(view)

            val bundle = Bundle()

            bundle.putString(Constants.NAME, mlist!![position].name!!.first)
            bundle.putString(Constants.CITY, mlist!![position].location!!.city)
            bundle.putString(Constants.IMAGE, mlist!![position].picture!!.large)
            bundle.putString(Constants.EMAIL, mlist!![position].email)
            bundle.putString(Constants.PHONE, mlist!![position].phone)

            navController.navigate(R.id.fragment_detail, bundle)

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