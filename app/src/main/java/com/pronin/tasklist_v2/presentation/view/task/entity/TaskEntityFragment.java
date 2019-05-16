package com.pronin.tasklist_v2.presentation.view.task.entity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.pronin.tasklist_v2.R;
import com.pronin.tasklist_v2.di.Injector;
import com.pronin.tasklist_v2.presentation.presenter.task.TaskEntityPresenter;


public class TaskEntityFragment extends MvpAppCompatFragment implements TaskEntityView {

    public static final String VALUE = "value";
    private static String mValue;
    private static String mDate;
    private TextView mTextView;
    private TextView mDateView;

    @ProvidePresenter
    TaskEntityPresenter mTaskEntityPresenter() {
        return Injector.getInstance().getAppComponent().getTaskEntityPresenter();
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            mValue = arguments.getString(VALUE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_entity_view, container, false);
        mTextView = view.findViewById(R.id.task_entity);
        mDateView = view.findViewById(R.id.task_entity_date);
        mTextView.setText(mValue);
        return view;
    }

    public static Fragment getInstance() {
        Bundle bundle = new Bundle();
        bundle.putString(VALUE, mValue);
        TaskEntityFragment fragment = new TaskEntityFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


}
