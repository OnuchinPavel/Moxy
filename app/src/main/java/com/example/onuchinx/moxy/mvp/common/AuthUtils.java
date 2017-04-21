package com.example.onuchinx.moxy.mvp.common;

/**
 * Created by onuchinx on 21/04/2017.
 */

public class AuthUtils {
    public  static  final  String TOKEN ="token";
    public static  String getToken(){
        return  PrefUtils.getPrefs().getString(TOKEN,"");
    }

    public static  void setToken(String token ){
        PrefUtils.getEditor().putString(TOKEN,token).commit();
    }
}
