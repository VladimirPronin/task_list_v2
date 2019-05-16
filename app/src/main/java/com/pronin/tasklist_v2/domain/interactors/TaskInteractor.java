package com.pronin.tasklist_v2.domain.interactors;

import android.util.Log;

import com.pronin.tasklist_v2.repository.db.room.ItemDao;
import com.pronin.tasklist_v2.repository.model.entities.TaskEntity;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class TaskInteractor implements ITaskIteractor {

    private static final String TAG = "TaskInteractorImpl";

    private ItemDao mItemDao;


    @Inject
    public TaskInteractor(ItemDao itemDao) {
        mItemDao = itemDao;
    }

    @Override
    public Flowable<List<TaskEntity>> getAll() {
        return mItemDao.getAll()
                .doOnSubscribe(subscription -> Log.d(TAG, "getAll: onSubscribe"))
                .doOnComplete(() -> Log.d(TAG, "getAll() called complete"));
    }
    @Override
    public Completable createTaskEntity(String value) {
        return insertToDB(value);
    }



    private Completable insertToDB(String value){
        return Completable.fromRunnable(() -> mItemDao.insert(createTask(value)))
                .doOnSubscribe(disposable -> Log.d(TAG, "insertToDB: subscribe"))
                .doOnComplete(() -> Log.d(TAG, "insertToDB: complete"));
    }



    public TaskEntity createTask(String value) {
        TaskEntity entity = new TaskEntity();
        Calendar calendar = Calendar.getInstance();
        String date = DateFormat.getDateInstance().format(calendar.getTime());
        entity.setContent(value);
        entity.setCreateDate(date);
        return entity;
    }



}
