package com.example.onuchinx.moxy.app;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;


import com.example.onuchinx.moxy.di.Appcomponent;
import com.example.onuchinx.moxy.di.DaggerAppcomponent;
import com.example.onuchinx.moxy.di.modules.ContextModule;

/**
 * Created by onuchinx on 21/04/2017.
 */

public class GithubApp extends Application {
    private static Appcomponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppComponent = DaggerAppcomponent.builder()
                .contextModule(new ContextModule(this))
                .build();

    }

    public static Appcomponent getAppcomponent() {
        return sAppComponent;
    }


    @VisibleForTesting
    public static void setAppComponent(@NonNull Appcomponent appComponent) {
        sAppComponent = appComponent;
    }

}
