package com.pronin.tasklist_v2.presentation.presenter.task;

import com.arellomobile.mvp.MvpPresenter;
import com.pronin.tasklist_v2.domain.interactors.ITaskIteractor;
import com.pronin.tasklist_v2.navigation.Screens;
import com.pronin.tasklist_v2.presentation.view.task.edit.TaskEntityEditView;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.terrakok.cicerone.Router;

public class TaskEntityEditPresenter extends MvpPresenter<TaskEntityEditView> {

    private final ITaskIteractor mTaskInteractor;
    private final Router mRouter;

    @Inject
    public TaskEntityEditPresenter(final ITaskIteractor taskInteractor, final Router router) {
        mTaskInteractor = taskInteractor;
        mRouter = router;
    }

    public void createTask(String value) {
        Disposable disposable = mTaskInteractor.createTaskEntity(value)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> mRouter.backTo(new Screens.TaskListScreen()));
    }


}
