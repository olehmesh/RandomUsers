package com.olehmesh.randomusers.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olehmesh.randomusers.Constants
import com.olehmesh.randomusers.databinding.MainListItemBinding
import com.olehmesh.randomusers.models.Result
import kotlinx.android.extensions.LayoutContainer


class UsersAdapter : PagedListAdapter<Result, UsersAdapter.ItemViewHolder>(DiffUtilCallBack()) {

    private lateinit var navController: NavController

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val v = LayoutInflater.from(parent.context)

        val binding = MainListItemBinding.inflate(v, parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, i: Int) {

        val mList: Result? = getItem(i)
        when {
            mList != null -> {
                itemViewHolder.bind(mList)
            }
        }

        itemViewHolder.itemView.setOnClickListener {

            navController = Navigation.findNavController(itemViewHolder.itemView)
            val builder = NavOptions.Builder()
            val navOptions = builder
                .setEnterAnim(com.olehmesh.randomusers.R.anim.slide_in_right)
                .setExitAnim(com.olehmesh.randomusers.R.anim.slide_out_right)
                .setPopEnterAnim(com.olehmesh.randomusers.R.anim.slide_in_left)
                .setPopExitAnim(com.olehmesh.randomusers.R.anim.slide_out_left)
                .build()

            val bundle = Bundle()

            bundle.putString(Constants.NAME, mList?.name!!.first)
            bundle.putString(Constants.CITY, mList.location!!.city)
            bundle.putString(Constants.IMAGE, mList.picture!!.large)
            bundle.putString(Constants.EMAIL, mList.email)
            bundle.putString(Constants.PHONE, mList.phone)

            navController.navigate(
                com.olehmesh.randomusers.R.id.fragment_detail,
                bundle,
                navOptions
            )

        }

    }

    inner class ItemViewHolder(private val binding: MainListItemBinding) :
        RecyclerView.ViewHolder(binding.root), LayoutContainer {

        override val containerView: View?
            get() = itemView


        fun bind(item: Result) {

            binding.result = item
            binding.executePendingBindings()

        }

    }

}