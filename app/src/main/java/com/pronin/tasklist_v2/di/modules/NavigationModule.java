package com.pronin.tasklist_v2.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class NavigationModule {
    @Provides
    @Singleton
    public Cicerone<Router> provideCicerone(){
        return Cicerone.create();
    }

    @Provides
    @Singleton
    public NavigatorHolder provideNavigationHolder(Cicerone<Router> cicerone){
        return cicerone.getNavigatorHolder();
    }

    @Provides
    @Singleton
    public Router provideRouter(Cicerone<Router> cicerone){
        return cicerone.getRouter();
    }
}
