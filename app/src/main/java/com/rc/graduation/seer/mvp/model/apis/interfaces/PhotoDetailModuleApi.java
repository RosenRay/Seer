package com.rc.graduation.seer.mvp.model.apis.interfaces;

import com.rc.graduation.seer.common.RequestCallBack;

import rx.Subscription;

/**
 * @version 1.0
 * @author  rosen
 * Created by Administrator on 2016/11/30.
 */

public interface PhotoDetailModuleApi<T> {

    Subscription saveImageAndGetImageUri(RequestCallBack<T> callBack,String url);

}
