package com.pronin.tasklist_v2.presentation.recycler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pronin.tasklist_v2.MainActivity;
import com.pronin.tasklist_v2.R;
import com.pronin.tasklist_v2.di.Injector;
import com.pronin.tasklist_v2.navigation.Screens;
import com.pronin.tasklist_v2.presentation.presenter.task.TaskEntityEditPresenter;
import com.pronin.tasklist_v2.presentation.view.task.edit.TaskEntityEditFragment;
import com.pronin.tasklist_v2.repository.model.entities.TaskEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

public class TaskItemAdapter extends RecyclerView.Adapter<TaskItemAdapter.ViewHolder> {

    private List<TaskEntity> mTaskEntities = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_task_entity_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        TaskEntity entity = mTaskEntities.get(position);
        Bundle bundl = new Bundle();
        bundl.putParcelable("entity", entity);
        TaskEntityEditFragment fragment = new TaskEntityEditFragment();
        fragment.setArguments(bundl);
        viewHolder.taskListEntity.setText(entity.getContent());
        viewHolder.taskListDate.setText(entity.getCreateDate());
        Injector.getInstance().getAppComponent().inject(viewHolder);
        viewHolder.taskListEntity.setOnClickListener(view -> viewHolder.mRouter.navigateTo(new Screens.TaskItemEditScreen(entity)));
    }

    @Override
    public int getItemCount() {
        return mTaskEntities.size();
    }

    public void setData(List<TaskEntity> items) {
        mTaskEntities.clear();
        mTaskEntities.addAll(items);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView taskListEntity;
        TextView taskListDate;

        @Inject
        Router mRouter;

        public ViewHolder(@NonNull View view) {
            super(view);
            taskListEntity = view.findViewById(R.id.task_entity);
            taskListDate = view.findViewById(R.id.task_entity_date);

        }
    }



    public void deleteData(List<TaskEntity> item) {
        mTaskEntities.remove(item);
        notifyDataSetChanged();
    }


}
