package com.example.onuchinx.moxy.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.onuchinx.moxy.mvp.models.Repository;
import com.example.onuchinx.moxy.mvp.views.HomeView;

/**
 * Created by onuchinx on 21/04/2017.
 */
@InjectViewState
public class HomePresenter extends MvpPresenter<HomeView> {
    public void onRepositorySelection(int position, Repository repository){
        getViewState().showDetails(position,repository);
        getViewState().setSelection(position);
        getViewState().showDetails(position,repository);
    }
}
