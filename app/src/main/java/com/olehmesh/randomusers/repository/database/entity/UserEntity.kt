package com.olehmesh.randomusers.repository.database.entity

import androidx.room.*

@Entity(
    tableName = "table_info",
    indices = [Index(value = ["name", "city", "image"], unique = true)]
)

data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    var name: String? = null,
    var city: String? = null,
    var image: String? = null
)
