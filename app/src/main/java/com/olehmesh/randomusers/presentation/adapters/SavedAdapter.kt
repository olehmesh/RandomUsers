package com.olehmesh.randomusers.presentation.adapters

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.olehmesh.randomusers.R
import com.olehmesh.randomusers.databinding.SavedListItemBinding
import com.olehmesh.randomusers.repository.database.relation.DateAndUser
import com.olehmesh.randomusers.repository.database.entity.UserEntity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.saved_list_item.*
import kotlinx.android.synthetic.main.saved_list_item.view.*

class SavedAdapter(var dbEntity: MutableList<DateAndUser>) :
    RecyclerView.Adapter<SavedAdapter.SavedListHolder>() {

    private lateinit var navController: NavController

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

            maps.setOnClickListener {

                val bundle = Bundle()

                bundle.putString(R.string.longitude.toString(), entity.date.longitude)
                bundle.putString(R.string.latitude.toString(), entity.date.latitude)
                bundle.putString(R.string.city.toString(), entity.user.city)

                navController =
                    Navigation.findNavController(
                        itemView.context as Activity,
                        R.id.nav_host_fragment
                    )
                navController.navigate(R.id.fragment_maps, bundle)

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
