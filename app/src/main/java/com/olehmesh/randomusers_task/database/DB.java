package com.olehmesh.randomusers_task.database;

import android.content.Context;
import androidx.room.Room;

public class DB {

    private static DatabaseManager DB_INSTANCE;

    public static DatabaseManager getDatabase(Context context) {

        if (DB_INSTANCE == null) {
            DB_INSTANCE = Room.databaseBuilder(context, DatabaseManager.class, "db_rand_users")
                    .allowMainThreadQueries()
                    .build();

        }
        return DB_INSTANCE;

    }
}