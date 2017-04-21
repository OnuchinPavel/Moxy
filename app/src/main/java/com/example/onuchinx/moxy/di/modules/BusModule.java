package com.example.onuchinx.moxy.di.modules;

import com.example.onuchinx.moxy.app.GithubApi;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by onuchinx on 21/04/2017.
 */

@Module
public class BusModule {
    @Provides
    @Singleton
    public Bus provideBus(GithubApi authApi) {
        return new Bus();
    }



}