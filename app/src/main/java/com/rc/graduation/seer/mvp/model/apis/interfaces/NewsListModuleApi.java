package com.rc.graduation.seer.mvp.model.apis.interfaces;

import com.rc.graduation.seer.common.RequestCallBack;

import rx.Subscription;

/**
 *  新闻模块 API接口
 * @version 1.0
 * Created by rosen on 2016/11/10 0010.
 */
public interface NewsListModuleApi<T> {

    Subscription loadNews(RequestCallBack<T> listener,String type,String id,int startPage);

}
