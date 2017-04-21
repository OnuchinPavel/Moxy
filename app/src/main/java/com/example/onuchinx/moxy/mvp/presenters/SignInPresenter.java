package com.example.onuchinx.moxy.mvp.presenters;

import android.text.TextUtils;
import android.util.Base64;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.sample.github.R;
import com.example.onuchinx.moxy.app.GithubApp;
import com.example.onuchinx.moxy.common.Utils;
import com.example.onuchinx.moxy.mvp.GithubService;
import com.example.onuchinx.moxy.mvp.common.AuthUtils;
import com.example.onuchinx.moxy.mvp.views.SignInView;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by onuchinx on 21/04/2017.
 */

@InjectViewState
public class SignInPresenter extends BasePresenter<SignInView> {

    @Inject
    GithubService githubService;

    public SignInPresenter(){

        GithubApp.getAppcomponent().inject(this);
    }
    public void signIn(String email, String password) {

        Integer emailError = null;
        Integer passwordError = null;

        getViewState().hideFormError();

        if (TextUtils.isEmpty(email)) {
            emailError = R.string.error_field_required;
        }

        if (TextUtils.isEmpty(password)) {
            passwordError = R.string.error_invalid_password;
        }

        if (emailError != null || passwordError != null) {
            getViewState().showFormError(emailError, passwordError);
            return;
        }

        getViewState().startSignIn();

        String credentials = String.format("%s:%s", email, password);

        final String token = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

        Subscription subscription = githubService.signIn(token)
                .doOnNext(user -> AuthUtils.setToken(token))
                .compose(Utils.applySchedulers())
                .subscribe(user -> {
                    getViewState().finishSignIn();
                    getViewState().successSignIn();
                }, exception -> {
                    getViewState().finishSignIn();
                    getViewState().failedSignIn(exception.getMessage());
                });

        unsubscribeOnDestroy(subscription);
    }

    public void onErrorCancel() {
        getViewState().hideError();
    }
}
