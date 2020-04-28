package com.olehmesh.randomusers_task.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.olehmesh.randomusers_task.R
import com.olehmesh.randomusers_task.database.entity.UserInfo
import com.olehmesh.randomusers_task.databinding.SavedListItemBinding
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.saved_list_item.*

class SavedAdapter(var dbEntity: MutableList<UserInfo>) :
    RecyclerView.Adapter<SavedAdapter.SavedListHolder>() {

    private var onDeleteListener: OnDeleteListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedListHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = SavedListItemBinding.inflate(inflater, parent, false)

        return SavedListHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedListHolder, position: Int) {

        holder.bind(dbEntity[position])

    }

    override fun getItemCount(): Int {

        return dbEntity.count()
    }

    inner class SavedListHolder(private val binding: SavedListItemBinding) :
        RecyclerView.ViewHolder(binding.root), LayoutContainer {

        override val containerView: View?
            get() = itemView

        fun bind(entity: UserInfo) {

            binding.userInfo = entity
            binding.executePendingBindings()

            Glide.with(itemView.context)
                .asBitmap()
                .load(entity.image)
                .apply(RequestOptions().override(Target.SIZE_ORIGINAL).encodeQuality(100))
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(ivSaved)

            delete.setOnClickListener {

                onDeleteListener!!.onDelete(dbEntity[adapterPosition])
                dbEntity.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)

            }

        }

    }

    fun setOnDeleteListener(onDeleteListener: OnDeleteListener) {
        this.onDeleteListener = onDeleteListener
    }

    interface OnDeleteListener {
        fun onDelete(entityDatabase: UserInfo)
    }
}