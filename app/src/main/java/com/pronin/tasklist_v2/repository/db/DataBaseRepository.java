package com.pronin.tasklist_v2.repository.db;


import com.pronin.tasklist_v2.repository.model.entities.TaskEntity;

import java.util.List;

public interface DataBaseRepository {
    List<TaskEntity> getAll();
    List<TaskEntity> getAllByLocationId(long locationId);
    void addItem(TaskEntity item);
    void delete(TaskEntity iteem);
    TaskEntity getById(long taskItemId);
    void update(TaskEntity item);
}
