package com.olehmesh.randomusers_task.database

import androidx.room.*
import com.olehmesh.randomusers_task.models.EntityData

@Dao
interface DaoMethods {

    @get:Query("SELECT * FROM EntityData")
    val all: List<EntityData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entityDatabase: EntityData)

    @Delete
    fun delete(entityDatabase: EntityData)

}