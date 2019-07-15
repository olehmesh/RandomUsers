package com.olehmesh.randomusers_task.database


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EntityData {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    var name: String? = null
    var city: String? = null
    var image: String? = null
}
