package com.rc.graduation.seer.mvp.base;

/**
 *  View 基类
 * Created by rosen on 2016/10/19 0019.
 */
public interface BaseView {

    void showProgress();

    void hideProgress();

    void showMsg(String message);
}
