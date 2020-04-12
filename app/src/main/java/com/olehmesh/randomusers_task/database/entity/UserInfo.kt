package com.olehmesh.randomusers_task.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "user_info",
    indices = [Index(value = ["name", "city", "image"], unique = true)]
)
class UserInfo {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
    lateinit var name: String
    lateinit var city: String
    lateinit var image: String


}
