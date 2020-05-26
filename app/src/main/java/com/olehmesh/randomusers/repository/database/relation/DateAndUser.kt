package com.olehmesh.randomusers.repository.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.olehmesh.randomusers.repository.database.entity.DateLatLng
import com.olehmesh.randomusers.repository.database.entity.UserEntity

data class DateAndUser(

    @Embedded
    var date: DateLatLng,

    @Relation(parentColumn = "parent_id", entityColumn = "id")
    var user: UserEntity

)
