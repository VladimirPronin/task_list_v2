package com.pronin.tasklist_v2.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.pronin.tasklist_v2.navigation.Screens;
import com.pronin.tasklist_v2.presentation.view.MainView;


import javax.inject.Inject;
import javax.inject.Singleton;

import ru.terrakok.cicerone.Router;

@InjectViewState
@Singleton
public class MainPresenter extends MvpPresenter<MainView> {

    private final Router mRouter;

    @Inject
    public MainPresenter(Router mRouter) {
        this.mRouter = mRouter;
    }

    public void navigateToItemList() {
        mRouter.navigateTo(new Screens.TaskListScreen());
    }
}
