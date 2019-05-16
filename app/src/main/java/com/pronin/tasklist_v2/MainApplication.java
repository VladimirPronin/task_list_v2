package com.pronin.tasklist_v2;

import android.app.Application;

import com.pronin.tasklist_v2.di.Injector;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.init(this);
    }
}
