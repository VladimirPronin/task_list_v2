package com.pronin.tasklist_v2.di.modules;

import com.pronin.tasklist_v2.domain.interactors.ITaskIteractor;
import com.pronin.tasklist_v2.domain.interactors.TaskInteractor;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class TaskInteractorModule {

    @Binds
    @Singleton
    public abstract ITaskIteractor bindTaskInteractor(TaskInteractor taskinteractor);
}
