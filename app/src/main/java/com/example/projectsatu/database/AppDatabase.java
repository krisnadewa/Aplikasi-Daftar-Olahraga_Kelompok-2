package com.example.projectsatu.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SaranModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase appDatabase;

    public abstract SaranDAO saranDAO();

    public static AppDatabase iniDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(
                    context,
                    AppDatabase.class,
                    "sport"
            ).allowMainThreadQueries().build();
        }
        return appDatabase;
    }

}
