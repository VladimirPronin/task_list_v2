package com.pronin.tasklist_v2.presentation.presenter.task;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.pronin.tasklist_v2.domain.interactors.ITaskIteractor;
import com.pronin.tasklist_v2.domain.interactors.TaskInteractor;
import com.pronin.tasklist_v2.presentation.view.task.entity.TaskEntityView;
import com.pronin.tasklist_v2.repository.model.entities.TaskEntity;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;


@InjectViewState
public class TaskEntityPresenter extends MvpPresenter<TaskEntityView>{

    private final ITaskIteractor mInteractor;
    private final Router mRouter;
    private final TaskEntity mItem;

    @Inject
    public TaskEntityPresenter(ITaskIteractor interactor, final Router router, final TaskEntity item) {
        mInteractor = interactor;
        mRouter = router;
        mItem = item;
    }
}
