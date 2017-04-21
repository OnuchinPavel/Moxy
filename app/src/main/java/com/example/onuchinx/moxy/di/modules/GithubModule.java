package com.example.onuchinx.moxy.di.modules;

import com.example.onuchinx.moxy.app.GithubApi;
import com.example.onuchinx.moxy.mvp.GithubService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by onuchinx on 21/04/2017.
 */

@Module(includes = ApiModule.class)
public class GithubModule {
    @Provides
    @Singleton
    public GithubService provideGithubService(GithubApi authApi){
        return  new GithubService(authApi);
    }
}
