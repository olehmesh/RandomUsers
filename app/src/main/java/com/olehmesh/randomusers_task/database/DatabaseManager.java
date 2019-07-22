package com.olehmesh.randomusers_task.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.olehmesh.randomusers_task.models.EntityData;

@Database(entities = {EntityData.class}, version = 1, exportSchema = false)

public abstract class DatabaseManager extends RoomDatabase {

    public abstract DaoMethods daoMethods();

}