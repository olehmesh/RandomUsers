package com.olehmesh.randomusers_task.database


import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["name", "city", "image"], unique = true)])
class EntityData {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    var name: String? = null
    var city: String? = null
    var image: String? = null
}
