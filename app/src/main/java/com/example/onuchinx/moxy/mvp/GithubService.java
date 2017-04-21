package com.example.onuchinx.moxy.mvp;

import com.example.onuchinx.moxy.app.GithubApi;
import com.example.onuchinx.moxy.mvp.models.Repository;
import com.example.onuchinx.moxy.mvp.models.User;

import java.util.List;

import rx.Observable;

/**
 * Created by onuchinx on 21/04/2017.
 */

public class GithubService {

    private GithubApi mGithubApi;

    public GithubService(GithubApi githubApi) {
        mGithubApi = githubApi;
    }


    public Observable<User> signIn(String token) {
        return mGithubApi.signIn(token);
    }

    public Observable<List<Repository>> getUserRepos(String user, int page, Integer pageSize) {
        return mGithubApi.getUserRepos(user, page, pageSize);
    }
}
