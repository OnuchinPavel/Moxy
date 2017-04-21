package com.example.onuchinx.moxy.app;

import com.example.onuchinx.moxy.mvp.models.Repository;
import com.example.onuchinx.moxy.mvp.models.SearchResult;
import com.example.onuchinx.moxy.mvp.models.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by onuchinx on 21/04/2017.
 */

public interface GithubApi {
    Integer PAGE_SIZE =50;

    @GET("/user")
    Observable<User> signIn(@Header("Authorization") String token);

    @GET("/search/repositories?sort=stars&order=desc")
    Observable<SearchResult> search(@Query("q")String query);

    @GET("/users/{login}/repos")
    Observable<List<Repository>> getUserRepos(@Path("login")String login, @Query("page") int page , @Query("per_page") int pageSize);
}
