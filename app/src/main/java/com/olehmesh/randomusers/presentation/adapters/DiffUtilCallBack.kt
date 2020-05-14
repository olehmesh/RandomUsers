package com.olehmesh.randomusers.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.olehmesh.randomusers.repository.network.retrofit_pojo.Result

class DiffUtilCallBack : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }

}