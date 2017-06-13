package com.rc.graduation.seer.mvp.view;

import com.rc.graduation.seer.mvp.model.entity.netease.NewsChannelTable;
import com.rc.graduation.seer.mvp.base.BaseView;

import java.util.List;

/**
 * @version 1.0
 * @author  rosen
 * Created by Administrator on 2016/11/23.
 */

public interface NewsChannelView extends BaseView{

    void updateRecyclerView(List<NewsChannelTable> newsChannelMine,List<NewsChannelTable> newsChannelRecommend);

}
