package com.pronin.tasklist_v2.presentation.view.task.list;

import com.arellomobile.mvp.MvpView;
import com.pronin.tasklist_v2.repository.model.entities.TaskEntity;

import java.util.List;

public interface TaskListView extends MvpView {
    void setData(List<TaskEntity> entityList);
    void deleteData (List<TaskEntity> entityList);
}
