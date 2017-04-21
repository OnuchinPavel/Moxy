package com.example.onuchinx.moxy.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.example.onuchinx.moxy.mvp.views.RepositoriesLikesView;
import com.example.onuchinx.moxy.mvp.views.RepositoriesView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by onuchinx on 21/04/2017.
 */
@InjectViewState
public class RepositoryLikesPresenter extends BasePresenter<RepositoriesLikesView> {
    public static final String  TAG = "RepositoryLikesPresenter";

    private List<Integer> mInProgress = new ArrayList<>();
    private  List<Integer> mLikedIds = new ArrayList<>();

    public void toggleLike(int id ){

        if(mInProgress.contains(id)){
            return;
        }
        mInProgress.add(id);
        getViewState().updateLikes(mInProgress,mLikedIds);

        final Observable<Boolean > toggleObservable  = Observable.create(subscriber -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            subscriber.onNext(!mLikedIds.contains(id));
        });

        Subscription subscription = toggleObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(isLiked -> {
                    onComplete(id, isLiked);
                }, throwable -> {
                    onFail(id);
                });
        unsubscribeOnDestroy(subscription);
    }

    private void onComplete(int id, Boolean isLiked) {
        if (!mInProgress.contains(id)) {
            return;
        }

        mInProgress.remove(Integer.valueOf(id));
        if (isLiked) {
            mLikedIds.add(id);
        } else {
            mLikedIds.remove(Integer.valueOf(id));
        }

        getViewState().updateLikes(mInProgress, mLikedIds);
    }

    private void onFail(int id) {
        if (!mInProgress.contains(id)) {
            return;
        }

        mInProgress.remove(Integer.valueOf(id));
        getViewState().updateLikes(mInProgress, mLikedIds);
    }
}
