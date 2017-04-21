package com.example.onuchinx.moxy.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.example.onuchinx.moxy.mvp.common.AuthUtils;
import com.example.onuchinx.moxy.mvp.views.SignOutView;

/**
 * Created by onuchinx on 21/04/2017.
 */
@InjectViewState
public class SignOutPresenter extends BasePresenter<SignOutView> {

    public  void signout(){
        AuthUtils.setToken("");
        getViewState().signOut();
    }

}
