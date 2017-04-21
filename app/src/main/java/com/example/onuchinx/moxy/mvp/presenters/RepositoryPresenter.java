package com.example.onuchinx.moxy.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.onuchinx.moxy.mvp.models.Repository;
import com.example.onuchinx.moxy.mvp.views.RepositoryView;

import java.util.List;

/**
 * Created by onuchinx on 21/04/2017.
 */

@InjectViewState
public class RepositoryPresenter extends MvpPresenter<RepositoryView> {


    private Repository repository;
    private List<Integer> mInProgress;
    private  List<Integer> mLikedIds;

    public RepositoryPresenter(Repository repository) {
        super();
        this.repository = repository;
    }
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().showRepositories(repository);

        updateLikes(mInProgress, mLikedIds);
    }
    public void updateLikes(List<Integer> inProgress, List<Integer> likedIds) {
        mInProgress = inProgress;
        mLikedIds = likedIds;

        if (repository == null || mInProgress == null || mLikedIds == null) {
            return;
        }

        boolean isInProgress = inProgress.contains(repository.getId());
        boolean isLiked = likedIds.contains(repository.getId());

        getViewState().updateLike(isInProgress, isLiked);
    }
}
