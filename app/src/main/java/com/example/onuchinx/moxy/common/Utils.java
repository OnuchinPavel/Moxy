package com.example.onuchinx.moxy.common;

import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by onuchinx on 21/04/2017.
 */

public class Utils {

    public static <T>Observable.Transformer<T,T> applySchedulers(){
        return  tObservable -> tObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
