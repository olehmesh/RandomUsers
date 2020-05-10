package com.olehmesh.randomusers.repository.database.entity

import androidx.room.*
import androidx.room.ForeignKey.CASCADE


@Entity(
    tableName = "table_date", indices = [Index(value = ["parent_id"], unique = true)],
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["id"], childColumns = ["parent_id"], onDelete = CASCADE, deferred = true
    )]
)

class DateCurrent(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "parent_id")
    var parentId: Int = 0,


    @ColumnInfo(name = "date_current")
    var dateCurrent: Long = 0

)

