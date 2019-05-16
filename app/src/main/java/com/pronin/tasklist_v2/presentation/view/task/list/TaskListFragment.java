package com.pronin.tasklist_v2.presentation.view.task.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.pronin.tasklist_v2.R;
import com.pronin.tasklist_v2.di.Injector;
import com.pronin.tasklist_v2.presentation.presenter.task.TaskListPresenter;
import com.pronin.tasklist_v2.presentation.recycler.TaskItemAdapter;
import com.pronin.tasklist_v2.repository.model.entities.TaskEntity;
import java.util.List;

import javax.inject.Inject;
import ru.terrakok.cicerone.Router;

public class TaskListFragment extends MvpAppCompatFragment implements TaskListView{

    List<TaskEntity> taskItem;
    private TaskItemAdapter adapter;

    @Inject
    Router mRouter;

    @InjectPresenter
    TaskListPresenter mTaskListPresenter;

    @ProvidePresenter
    TaskListPresenter providePresenter() {
        return Injector.getInstance().getAppComponent().getTaskListPresenter();
    }

    @Override
    public void setData(List<TaskEntity> entityList) {
        adapter.setData(entityList);
    }

    @Override
    public void deleteData(final List<TaskEntity> entityList) {
        adapter.deleteData(entityList);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_entity_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_entity_main_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        adapter = new TaskItemAdapter();
        recyclerView.setAdapter(adapter);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.fab_task_list_addnew);
        floatingActionButton.setOnClickListener(view1 -> mTaskListPresenter.onAddButtonClick());
        return view;
    }
}
