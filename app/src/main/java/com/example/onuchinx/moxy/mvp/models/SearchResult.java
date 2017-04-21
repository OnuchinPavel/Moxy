package com.example.onuchinx.moxy.mvp.models;

import java.util.List;

/**
 * Created by onuchinx on 21/04/2017.
 */

public class SearchResult {
    private int mTotalCount;
    private boolean mIncompleteResults;
    private List<Repository> mItems;

    public List<Repository> getRepositories() {
        return mItems;
    }
}