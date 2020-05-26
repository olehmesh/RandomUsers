package com.olehmesh.randomusers.repository.database.entity

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(
    tableName = "table_date_lat_lng", indices = [Index(value = ["parent_id"], unique = true)],
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["id"], childColumns = ["parent_id"], onDelete = CASCADE, deferred = true
    )]
)

data class DateLatLng(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "parent_id")
    var parentId: Int = 0,


    @ColumnInfo(name = "date")
    var date: String? = null,

    @ColumnInfo(name = "longitude")
    var longitude: String? = null,

    @ColumnInfo(name = "latitude")
    var latitude: String? = null


)

