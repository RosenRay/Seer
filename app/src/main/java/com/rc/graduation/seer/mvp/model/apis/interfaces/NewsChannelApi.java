package com.rc.graduation.seer.mvp.model.apis.interfaces;

import com.rc.graduation.seer.common.RequestCallBack;
import com.rc.graduation.seer.mvp.base.BaseApi;
import com.rc.graduation.seer.mvp.model.entity.netease.NewsChannelTable;

import java.util.List;
import java.util.Map;

import rx.Subscription;

/**
 * @version 1.0
 * @author  rosen
 * Created by Administrator on 2016/11/23.
 */

public interface NewsChannelApi extends BaseApi{

    Subscription loadNewsChannels(RequestCallBack<Map<Integer, List<NewsChannelTable>>> callBack);

    void swapDB(int fromPosition,int toPosition);

    void updateDB(NewsChannelTable newsChannelTable,boolean isChannelMine);

}
