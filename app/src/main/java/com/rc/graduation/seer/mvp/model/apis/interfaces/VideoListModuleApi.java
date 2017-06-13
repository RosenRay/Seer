package com.rc.graduation.seer.mvp.model.apis.interfaces;

import com.rc.graduation.seer.common.RequestCallBack;
import rx.Subscription;

/**
 *  视频模块
 *  @version 1.0
 *  @author  rosen
 * Created by rosen on 2016/10/24 0024.
 */
public interface VideoListModuleApi<T> {

    Subscription getVideoList(RequestCallBack<T> callBack,String videoType,int startPage);
}

