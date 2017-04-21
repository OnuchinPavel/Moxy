package com.example.onuchinx.moxy.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by onuchinx on 21/04/2017.
 */
@Module
public class ContextModule {
    private Context mConntext;

    public ContextModule(Context mConntext) {
        this.mConntext = mConntext;
    }

    @Provides
    @Singleton
    public Context provideContext()
    {
        return  mConntext;
    }
}
