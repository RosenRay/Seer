package com.rc.graduation.seer.mvp.view;

import com.rc.graduation.seer.mvp.model.entity.netease.NewsSummary;
import com.rc.graduation.seer.mvp.base.BaseView;

import java.util.List;

/**
 * @version 1.0
 * Created by rosen on 2016/11/11 0011.
 */
public interface NewsListView extends BaseView {

    void setNewsList(List<NewsSummary> newsSummaryList,int loadType);

    void updateErrorView(int loadType);
}
