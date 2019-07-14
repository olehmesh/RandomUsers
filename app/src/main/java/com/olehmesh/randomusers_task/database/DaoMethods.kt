package com.olehmesh.randomusers_task.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoMethods {

    @get:Query("SELECT * FROM EntityData")
    val all: List<EntityData>

    @Insert
    fun insert(entityDatabase: EntityData)

    @Delete
    fun delete(entityDatabase: EntityData)

}