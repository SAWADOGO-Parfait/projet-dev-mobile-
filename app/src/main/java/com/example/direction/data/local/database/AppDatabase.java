package com.example.direction.data.local.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

// Corriger les imports selon votre structure
import com.example.direction.data.local.database.dao.AgentDao;
import com.example.direction.data.local.database.dao.ServiceDao;
import com.example.direction.data.local.database.entities.Agent;
import com.example.direction.data.local.database.entities.Service;

@Database(entities = {Agent.class, Service.class}, version = 1, exportSchema = false)
@TypeConverters({DateConverter.class, StatutConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract AgentDao agentDao();
    public abstract ServiceDao serviceDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(android.content.Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "direction_database"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}