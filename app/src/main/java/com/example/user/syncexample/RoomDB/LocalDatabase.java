package com.example.user.syncexample.RoomDB;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.user.syncexample.Dao.DaoDB;
import com.example.user.syncexample.Entituy.Local;

@Database(entities = {Local.class},version = 1)
public abstract class LocalDatabase extends RoomDatabase {

    public abstract DaoDB daoDB();

    public static volatile LocalDatabase INSTANCE;

    public static LocalDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LocalDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LocalDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
