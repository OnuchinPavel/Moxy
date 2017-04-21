package com.example.onuchinx.moxy.di.modules;

import com.example.onuchinx.moxy.app.GithubApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by onuchinx on 21/04/2017.
 */
@Module(includes = {RetrofitModule.class})
public class ApiModule {
    @Provides
    @Singleton
    public GithubApi provideAuthAoi(Retrofit retrofit){
        return  retrofit.create(GithubApi.class);
    }
}
