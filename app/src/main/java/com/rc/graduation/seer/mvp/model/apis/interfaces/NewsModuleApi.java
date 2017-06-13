package com.rc.graduation.seer.mvp.model.apis.interfaces;

import com.rc.graduation.seer.common.RequestCallBack;
import com.rc.graduation.seer.mvp.base.BaseApi;
import com.rc.graduation.seer.mvp.model.entity.netease.NewsChannelTable;
import com.rc.graduation.seer.mvp.model.entity.netease.NewsDetail;
import com.rc.graduation.seer.mvp.model.entity.netease.NewsSummary;

import java.util.List;

import rx.Subscription;

/**
 *  新闻模块 API接口
 * @version 1.0
 * Created by rosen on 2016/11/14 0014.
 */
public interface NewsModuleApi extends BaseApi{

    Subscription loadNewsChannel(RequestCallBack<List<NewsChannelTable>> callBack);

    Subscription loadNews(RequestCallBack<List<NewsSummary>> listener, String type, String id, int startPage);

    Subscription getNewsDetail(RequestCallBack<NewsDetail> callBack, String postId);
}
