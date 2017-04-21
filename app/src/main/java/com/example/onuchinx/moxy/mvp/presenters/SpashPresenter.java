package com.example.onuchinx.moxy.mvp.presenters;

import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.onuchinx.moxy.mvp.common.AuthUtils;
import com.example.onuchinx.moxy.mvp.views.SplashView;

/**
 * Created by onuchinx on 21/04/2017.
 */


public class SpashPresenter extends MvpPresenter<SplashView> {
    @Override
    public void attachView(SplashView view) {
        super.attachView(view);

        view.setAuthorized(!TextUtils.isEmpty(AuthUtils.getToken()));
    }
}
