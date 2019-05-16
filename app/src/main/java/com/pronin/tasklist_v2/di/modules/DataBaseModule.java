package com.pronin.tasklist_v2.di.modules;


import android.arch.persistence.room.Room;
import android.content.Context;

import com.pronin.tasklist_v2.repository.db.room.ItemDao;
import com.pronin.tasklist_v2.repository.db.room.RoomDB;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataBaseModule {

    @Provides
    @Singleton
    public RoomDB createDB(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, "item_database")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    public ItemDao provideItemDao(RoomDB roomDB) {
        return roomDB.getItemDao();
    }
}
