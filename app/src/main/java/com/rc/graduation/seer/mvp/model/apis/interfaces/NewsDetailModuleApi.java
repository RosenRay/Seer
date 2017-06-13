package com.rc.graduation.seer.mvp.model.apis.interfaces;

import com.rc.graduation.seer.common.RequestCallBack;

import rx.Subscription;

/**
 * @version 1.0
 * Created by rosen on 2016/11/15 0015.
 */
public interface NewsDetailModuleApi<T> {

    Subscription getNewsDetail(RequestCallBack<T> callBack,String postId);

}
