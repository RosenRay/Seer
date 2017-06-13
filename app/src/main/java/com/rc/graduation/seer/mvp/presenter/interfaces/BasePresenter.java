package com.rc.graduation.seer.mvp.presenter.interfaces;

import rx.Subscription;

/**
 *  Presenter 基类
 *
 * Created by rosen on 2016/10/19 0019.
 */
public interface BasePresenter {

    //创建
    void onCreate();

    void onDestroy();

    void unSubscribe(Subscription subscription);
}
