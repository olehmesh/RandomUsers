package com.olehmesh.randomusers_task.database.entity

import androidx.room.*
import androidx.room.ForeignKey.CASCADE


@Entity(
    tableName = "current_date", indices = [Index(value = ["parent_id"], unique = true)],
    foreignKeys = [ForeignKey(
        entity = UserInfo::class,
        parentColumns = ["id"], childColumns = ["parent_id"], onDelete = CASCADE, deferred = true
    )]
)

class DateCurrent(

    @ColumnInfo(name = "date_current")
    var dateCurrent: Long = 0,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "parent_id")
    var parentId: Int = 0
)

