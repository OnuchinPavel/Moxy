package com.example.onuchinx.moxy.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.onuchinx.moxy.mvp.models.Repository;

/**
 * Created by onuchinx on 21/04/2017.
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface HomeView extends MvpView {
    void showDetailsContainer();
    void setSelection(int position);
    @StateStrategyType(OneExecutionStateStrategy.class)
    void  showDetails(int position, Repository repository);
}
