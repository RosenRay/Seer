package com.rc.graduation.seer.mvp.model.apis.interfaces;

import com.rc.graduation.seer.common.RequestCallBack;
import com.rc.graduation.seer.mvp.base.BaseApi;
import com.rc.graduation.seer.mvp.model.entity.videos.VideoChannel;
import com.rc.graduation.seer.mvp.model.entity.videos.VideoData;

import java.util.List;

import rx.Subscription;

/**
 * @version 1.0
 * @author  rosen
 * Created by Administrator on 2016/11/26.
 */

public interface VideoModuleApi extends BaseApi{

    Subscription getVideoChannelList(RequestCallBack<List<VideoChannel>> callBack);

    Subscription getVideoList(RequestCallBack<List<VideoData>> callBack, String videoType, int startPage);
}
