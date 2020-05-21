package com.olehmesh.randomusers.repository.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.olehmesh.randomusers.repository.database.entity.DateCurrent
import com.olehmesh.randomusers.repository.database.entity.UserEntity

data class DateAndInfo(

    @Embedded
    var dateCurrent: DateCurrent,


    @Relation(parentColumn = "parent_id", entityColumn = "id")
    var user: UserEntity

)
