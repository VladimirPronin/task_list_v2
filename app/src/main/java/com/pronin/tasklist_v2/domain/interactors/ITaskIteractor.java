package com.pronin.tasklist_v2.domain.interactors;

import com.pronin.tasklist_v2.repository.model.entities.TaskEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface ITaskIteractor {

    Flowable<List<TaskEntity>> getAll();
    Completable createTaskEntity(String value);

}
