package com.pronin.tasklist_v2.di;

import android.content.Context;

public class Injector {

    private static volatile Injector sInjector;
    private final AppComponent mAppComponent;

    protected Injector(Context context) {
        mAppComponent = DaggerAppComponent.builder()
                .context(context)
                .build();
    }

    public static synchronized void init(Context context) {
        if (sInjector == null) {
            synchronized (Injector.class) {
                if (sInjector == null) {
                    sInjector = new Injector(context);
                }
            }
        }
    }

    public static Injector getInstance() {
        return sInjector;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
