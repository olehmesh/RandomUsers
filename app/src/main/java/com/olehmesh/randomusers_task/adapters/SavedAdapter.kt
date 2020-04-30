package com.olehmesh.randomusers_task.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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