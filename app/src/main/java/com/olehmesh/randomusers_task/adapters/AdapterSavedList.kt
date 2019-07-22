package com.olehmesh.randomusers_task.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.olehmesh.randomusers_task.R
import com.olehmesh.randomusers_task.database.EntityData
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.saved_list_item.*

class AdapterSavedList(private val dbEntityModels: MutableList<EntityData>) :
    RecyclerView.Adapter<AdapterSavedList.SavedListHolder>() {

    private var onDeleteListener: OnDeleteListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedListHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.saved_list_item, parent, false)

        return SavedListHolder(view)
    }

    override fun onBindViewHolder(holder: SavedListHolder, position: Int) {

        holder.bind(dbEntityModels[position])

    }

    override fun getItemCount(): Int {

        return dbEntityModels.size
    }

    inner class SavedListHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        fun bind(entity: EntityData) {

            savedName.text = entity.name
            savedCity.text = entity.city

            Glide.with(itemView.context)
                .asBitmap()
                .load(entity.image)
                .apply(RequestOptions().override(Target.SIZE_ORIGINAL).encodeQuality(100))
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(ivSaved)


            delete.setOnClickListener {
                onDeleteListener!!.onDelete(dbEntityModels[adapterPosition])
                dbEntityModels.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }

        }

    }

    fun setOnDeleteListener(onDeleteListener: OnDeleteListener) {
        this.onDeleteListener = onDeleteListener
    }

    interface OnDeleteListener {
        fun onDelete(entityDatabase: EntityData)
    }
}