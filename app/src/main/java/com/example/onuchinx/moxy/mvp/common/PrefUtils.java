package com.example.onuchinx.moxy.mvp.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.onuchinx.moxy.app.GithubApp;

/**
 * Created by onuchinx on 21/04/2017.
 */

public class PrefUtils {
    public  static  final  String PREF_NAME = "github";
    public  static SharedPreferences getPrefs(){
        return GithubApp.getAppcomponent().getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getEditor(){
        return  getPrefs().edit();
    }
}
