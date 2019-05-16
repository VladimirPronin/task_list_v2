package com.pronin.tasklist_v2.repository.db;

import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.pronin.tasklist_v2.repository.db.room.RoomDB;
import com.pronin.tasklist_v2.repository.model.entities.TaskEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DataBaseRepositoryImpl implements DataBaseRepository {

    private Context mContext;
    private RoomDB mRoomDB;


    @Inject
    public DataBaseRepositoryImpl(final Context context, final RoomDB roomDB) {
        mContext = context;
        mRoomDB = roomDB;
    }

    @Override
    public List<TaskEntity> getAll() {
        return null;
    }

    @Override
    public List<TaskEntity> getAllByLocationId(final long locationId) {
        return null;
    }

    @Override
    public void addItem(final TaskEntity item) {
    }

    @Override
    public void delete(final TaskEntity iteem) {
    }

    @Override
    public TaskEntity getById(final long taskItemId) {
        return null;
    }

    @Override
    public void update(final TaskEntity item) {

    }
}
