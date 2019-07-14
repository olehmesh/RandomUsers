package com.olehmesh.randomusers_task.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {EntityData.class}, version = 1, exportSchema = false)

public abstract class DatabaseManager extends RoomDatabase {

    public abstract DaoMethods daoMethods();

}