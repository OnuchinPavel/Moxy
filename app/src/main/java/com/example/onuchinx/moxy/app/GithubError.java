package com.example.onuchinx.moxy.app;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by onuchinx on 21/04/2017.
 */

public class GithubError extends Throwable {

    public GithubError(ResponseBody responseBody){
        super(getMassage(responseBody));

    }

    private static  String getMassage(ResponseBody responseBody){
        try
        {
            return  new JSONObject(responseBody.string()).optString("message");
        }
        catch (JSONException | IOException e ){
            e.printStackTrace();
        }
        return  "Unknown exeption ";
    }
}
