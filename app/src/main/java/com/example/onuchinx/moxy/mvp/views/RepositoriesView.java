package com.example.onuchinx.moxy.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.onuchinx.moxy.mvp.models.Repository;

import java.util.List;

/**
 * Created by onuchinx on 21/04/2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface RepositoriesView extends MvpView {
    void showError(String  message);
    void hideError();
    void onStartLoading();
    void onFinishLoading();
    void showRefreshing();
    void hideRefreshing();
    void showListProgress();
    void hideListProgress();
    void setRepositories(List<Repository> repositories,boolean maybeMore);
    @StateStrategyType(AddToEndStrategy.class)
    void addRepositories(List<Repository> repositories,boolean maybeMore);
}
