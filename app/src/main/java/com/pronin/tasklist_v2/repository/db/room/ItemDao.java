package com.pronin.tasklist_v2.repository.db.room;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.pronin.tasklist_v2.repository.model.entities.TaskEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ItemDao {
    @Query("SELECT * FROM item_table")
    Flowable<List<TaskEntity>> getAll();

    @Query("SELECT * FROM item_table WHERE id = :id")
    TaskEntity getById(long id);

    @Insert
    void insert(TaskEntity taskEntity);

    @Delete
    void delete(TaskEntity taskEntity);

    @Query("SELECT * FROM item_table WHERE geoId = :geoId")
    List<TaskEntity> getByGeoId(long geoId);

    @Update
    void update (TaskEntity taskEntity);
}
