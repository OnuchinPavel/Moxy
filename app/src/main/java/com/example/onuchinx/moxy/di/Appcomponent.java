package com.example.onuchinx.moxy.di;

import android.content.Context;

import com.example.onuchinx.moxy.di.modules.BusModule;
import com.example.onuchinx.moxy.di.modules.ContextModule;
import com.example.onuchinx.moxy.di.modules.GithubModule;
import com.example.onuchinx.moxy.mvp.GithubService;
import com.example.onuchinx.moxy.mvp.presenters.RepositoriesPresenter;
import com.example.onuchinx.moxy.mvp.presenters.RepositoryLikesPresenter;
import com.example.onuchinx.moxy.mvp.presenters.SignInPresenter;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {ContextModule.class, BusModule.class, GithubModule.class})
public interface Appcomponent {
    Context getContext();
    GithubService getAuthService();
    Bus getBus();

    void inject(SignInPresenter presenter);
    void inject(RepositoriesPresenter repositoriesPresenter);
    void inject(RepositoryLikesPresenter repositoryLikesPresenter);

}
