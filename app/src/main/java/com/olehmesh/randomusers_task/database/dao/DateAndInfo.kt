package com.olehmesh.randomusers_task.database.dao

import androidx.room.ColumnInfo
import androidx.room.Relation
import com.olehmesh.randomusers_task.database.entity.UserInfo

class DateAndInfo {

    @ColumnInfo(name = "parent_id")
    var parentId: Int = 0


    @ColumnInfo(name = "date_current")
    var dateCurrent: Long = 0

    @Relation(parentColumn = "parent_id", entityColumn = "id")
    var userInfo: List<UserInfo>? = null
}
