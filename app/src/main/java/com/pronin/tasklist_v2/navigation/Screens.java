package com.pronin.tasklist_v2.navigation;

import android.support.v4.app.Fragment;

import com.pronin.tasklist_v2.presentation.view.task.edit.TaskEntityEditFragment;
import com.pronin.tasklist_v2.presentation.view.task.entity.TaskEntityFragment;
import com.pronin.tasklist_v2.presentation.view.task.list.TaskListFragment;
import com.pronin.tasklist_v2.repository.model.entities.TaskEntity;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {

    public static class TaskEntityFragmentScreen extends SupportAppScreen {

        private final String value;


        public TaskEntityFragmentScreen(final String value) {
            this.value = value;
        }

        @Override
        public Fragment getFragment() {
            return TaskEntityFragment.getInstance();
        }
    }

    public static class TaskListScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new TaskListFragment();
        }
    }

    public static class TaskItemScreen extends SupportAppScreen {

        @Override
        public Fragment getFragment() {
            return new TaskEntityFragment();
        }
    }

    public static class TaskItemEditScreen extends SupportAppScreen {
        private  TaskEntity mEntity;

        public TaskItemEditScreen (TaskEntity taskEntity) {
           this.mEntity = taskEntity;
        }

        @Override
        public Fragment getFragment() {
            return TaskEntityEditFragment.getInstance();
        }
    }
    public static class CreateTaskScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new TaskEntityEditFragment();
        }
    }
}
