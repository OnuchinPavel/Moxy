package com.example.onuchinx.moxy.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by onuchinx on 21/04/2017.
 */

public interface RepositoriesLikeView extends MvpView {
    @StateStrategyType(SingleStateStrategy.class)
    void setState(boolean isInProgress,boolean isLiked);


}
