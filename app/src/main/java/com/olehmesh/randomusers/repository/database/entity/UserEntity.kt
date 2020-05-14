package com.olehmesh.randomusers.repository.database.entity

import android.graphics.drawable.Drawable
import androidx.databinding.BindingAdapter
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView


@Entity(
    tableName = "table_info",
    indices = [Index(value = ["name", "city", "image"], unique = true)]
)
class UserEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
    var name: String = ""
    var city: String = ""
    var image: String = ""


    @ColumnInfo(name = "date_current")
    var dateCurrent: Long = 0

}
