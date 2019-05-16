package com.pronin.tasklist_v2.presentation.presenter.task;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.pronin.tasklist_v2.domain.interactors.ITaskIteractor;
import com.pronin.tasklist_v2.navigation.Screens;
import com.pronin.tasklist_v2.presentation.view.task.list.TaskListView;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.terrakok.cicerone.Router;

@InjectViewState
@Singleton
public class TaskListPresenter extends MvpPresenter<TaskListView> {

    private final ITaskIteractor mTaskInteractor;
    private final Router mRouter;
    private Disposable mDisposable;

    @Inject
    public TaskListPresenter(final ITaskIteractor taskInteractor, final Router router) {
        mTaskInteractor = taskInteractor;
        this.mRouter = router;
    }

    @Override
    protected void onFirstViewAttach() {
        mDisposable = mTaskInteractor.getAll()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(value -> {
                    getViewState().setData(value);
                });
    }

    @Override
    public void onDestroy() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    public void onAddButtonClick() {
        mRouter.navigateTo(new Screens.CreateTaskScreen());
    }
}
