package com.rc.graduation.seer.mvp.view;

import com.rc.graduation.seer.mvp.model.entity.netease.NewsDetail;
import com.rc.graduation.seer.mvp.base.BaseView;

/**
 * @version 1.0
 * Created by rosen on 2016/11/15 0015.
 */
public interface NewsDetailView extends BaseView{

    void showNewsContent(NewsDetail newsDetail);

}
