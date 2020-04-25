package com.olehmesh.randomusers_task.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "table_info",
    indices = [Index(value = ["name", "city", "image"], unique = true)]
)
class UserInfo {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
    var name: String = ""
    var city: String = ""
    var image: String = ""


    @ColumnInfo(name = "date_current")
    var dateCurrent: Long = 0

}
