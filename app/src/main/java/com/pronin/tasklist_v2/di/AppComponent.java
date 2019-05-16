package com.pronin.tasklist_v2.di;


import android.content.Context;

import com.pronin.tasklist_v2.MainActivity;
import com.pronin.tasklist_v2.di.modules.DataBaseModule;
import com.pronin.tasklist_v2.di.modules.NavigationModule;
import com.pronin.tasklist_v2.di.modules.PresenterModule;
import com.pronin.tasklist_v2.di.modules.RepositoryModule;
import com.pronin.tasklist_v2.di.modules.TaskInteractorModule;
import com.pronin.tasklist_v2.presentation.presenter.MainPresenter;
import com.pronin.tasklist_v2.presentation.presenter.task.TaskEntityEditPresenter;
import com.pronin.tasklist_v2.presentation.presenter.task.TaskEntityPresenter;
import com.pronin.tasklist_v2.presentation.presenter.task.TaskListPresenter;
import com.pronin.tasklist_v2.presentation.recycler.TaskItemAdapter;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {DataBaseModule.class,
        NavigationModule.class,
        PresenterModule.class,
        TaskInteractorModule.class,
        RepositoryModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject(TaskItemAdapter.ViewHolder viewHolder);

    MainPresenter getMainPresenter();

    TaskEntityPresenter getTaskEntityPresenter();
    TaskListPresenter getTaskListPresenter();

    TaskEntityEditPresenter getTaskEditPresenter();


    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder context(Context context);

        AppComponent build();
    }
}
