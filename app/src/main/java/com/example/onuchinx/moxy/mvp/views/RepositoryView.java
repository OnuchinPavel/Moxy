package com.example.onuchinx.moxy.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.example.onuchinx.moxy.mvp.models.Repository;

/**
 * Created by onuchinx on 21/04/2017.
 */

public interface RepositoryView extends MvpView {
    void showRepositories(Repository repository);
    void  updateLike(boolean isinProgress,boolean isLiked);
}
