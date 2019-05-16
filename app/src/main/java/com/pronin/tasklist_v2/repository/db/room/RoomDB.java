package com.pronin.tasklist_v2.repository.db.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.pronin.tasklist_v2.repository.model.entities.TaskEntity;

@Database(entities = {TaskEntity.class}, version = 2, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    public abstract ItemDao getItemDao();

}
