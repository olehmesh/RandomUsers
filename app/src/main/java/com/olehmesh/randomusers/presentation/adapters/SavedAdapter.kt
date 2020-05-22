package com.olehmesh.randomusers.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olehmesh.randomusers.databinding.SavedListItemBinding
import com.olehmesh.randomusers.repository.database.relation.DateAndUser
import com.olehmesh.randomusers.repository.database.entity.UserEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.saved_list_item.*

class SavedAdapter(var dbEntity: MutableList<DateAndUser>) :
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

        fun bind(entity: DateAndUser) {

            binding.dateAndUser = entity
            binding.executePendingBindings()

            delete.setOnClickListener {

                onDeleteListener!!.onDelete(dbEntity[adapterPosition].user)

                dbEntity.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)

            }

        }

    }


    fun setOnDeleteListener(onDeleteListener: OnDeleteListener) {
        this.onDeleteListener = onDeleteListener
    }

    interface OnDeleteListener {
        fun onDelete(userEntity: UserEntity)
    }

}
