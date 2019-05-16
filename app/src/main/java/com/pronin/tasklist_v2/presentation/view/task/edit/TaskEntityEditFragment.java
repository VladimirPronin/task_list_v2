package com.pronin.tasklist_v2.presentation.view.task.edit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.pronin.tasklist_v2.R;
import com.pronin.tasklist_v2.di.Injector;
import com.pronin.tasklist_v2.presentation.presenter.task.TaskEntityEditPresenter;
import com.pronin.tasklist_v2.presentation.view.task.entity.TaskEntityFragment;

public class TaskEntityEditFragment extends MvpAppCompatFragment implements TaskEntityEditView {

    private EditText mEditText;
    private String mStateText;
    private Button mSaveButton;
    private Button mDeleteButton;
    private static final String STATE = "State";


    public TaskEntityEditFragment() {
    }

    @InjectPresenter
    TaskEntityEditPresenter mTaskEntityEditPresenter;

    @ProvidePresenter
    TaskEntityEditPresenter provideTaskEntityEditPresenter() {
        return Injector.getInstance().getAppComponent().getTaskEditPresenter();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        mStateText = mEditText.getText().toString();
        savedInstanceState.putString(STATE, mStateText);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_task_entity, container, false);
        mEditText = view.findViewById(R.id.edit_task_entity_field);
        mSaveButton = view.findViewById(R.id.edit_task_save_button);
        mEditText.setText(mStateText);
        mSaveButton.setOnClickListener(v -> mTaskEntityEditPresenter.createTask(mEditText.getText().toString()));
//        mDeleteButton.setOnClickListener(v -> mTaskEntityEditPresenter.deleteTask());
        return view;
    }

    public static Fragment getInstance() {
        Bundle bundle = new Bundle();
        bundle.getParcelable("entity");
        TaskEntityFragment fragment = new TaskEntityFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


}
