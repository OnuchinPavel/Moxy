package com.example.onuchinx.moxy.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.onuchinx.moxy.mvp.presenters.SpashPresenter;
import com.example.onuchinx.moxy.mvp.views.SplashView;

/**
 * Created by onuchinx on 21/04/2017.
 */

public class SplashActivity extends MvpAppCompatActivity implements SplashView {

    @InjectPresenter
    SpashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // By default view attaches to presenter in onResume() method,
        // but we attach it manually for earlier check authorization state.
        getMvpDelegate().onAttach();
    }

    @Override
    public void setAuthorized(boolean isAuthorized) {
        startActivity(new Intent(this, isAuthorized ? HomeActivity.class : SignInActivity.class));
    }
}