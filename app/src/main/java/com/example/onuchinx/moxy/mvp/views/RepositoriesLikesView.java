package com.example.onuchinx.moxy.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

/**
 * Created by onuchinx on 21/04/2017.
 */

public interface RepositoriesLikesView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void updateLikes(List<Integer> inProgress,List<Integer> likedIds);
}
