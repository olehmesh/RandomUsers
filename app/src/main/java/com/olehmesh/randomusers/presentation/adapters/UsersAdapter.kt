package com.olehmesh.randomusers.presentation.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.olehmesh.randomusers.R
import com.olehmesh.randomusers.databinding.MainListItemBinding
import com.olehmesh.randomusers.repository.models.Result
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
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_right)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_left)
                .build()

            val bundle = Bundle()

            bundle.putString(R.string.name.toString(), mList?.name!!.first)
            bundle.putString(R.string.city.toString(), mList.location!!.city)
            bundle.putString(R.string.image.toString(), mList.picture!!.large)
            bundle.putString(R.string.email.toString(), mList.email)
            bundle.putString(R.string.phone.toString(), mList.phone)

            navController.navigate(
                R.id.fragment_detail,
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