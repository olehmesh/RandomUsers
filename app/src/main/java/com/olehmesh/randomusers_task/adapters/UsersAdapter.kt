package com.olehmesh.randomusers_task.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.olehmesh.randomusers_task.Constants
import com.olehmesh.randomusers_task.R
import com.olehmesh.randomusers_task.models.Result
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.main_list_item.*

class UsersAdapter(var mlist: List<Result>?) : RecyclerView.Adapter<UsersAdapter.ItemViewHolder>() {

    private lateinit var navController: NavController

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.main_list_item, parent, false)

        return ItemViewHolder(v)
    }

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, i: Int) {

        itemViewHolder.bind(mlist!![i])

        itemViewHolder.itemView.setOnClickListener {

            navController = Navigation.findNavController(itemViewHolder.itemView)
            val builder = NavOptions.Builder()
            val navOptions = builder
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_right)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_left)
                .build()

            val bundle = Bundle()

            bundle.putString(Constants.NAME, mlist!![i].name!!.first)
            bundle.putString(Constants.CITY, mlist!![i].location!!.city)
            bundle.putString(Constants.IMAGE, mlist!![i].picture!!.large)
            bundle.putString(Constants.EMAIL, mlist!![i].email)
            bundle.putString(Constants.PHONE, mlist!![i].phone)

            navController.navigate(R.id.fragment_detail, bundle, navOptions)

        }

    }

    override fun getItemCount(): Int {
        return if (mlist == null) {
            0
        } else mlist!!.size
    }

    fun setData(mList: List<Result>) {
        this.mlist = mList
        notifyDataSetChanged()
    }


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {

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
}