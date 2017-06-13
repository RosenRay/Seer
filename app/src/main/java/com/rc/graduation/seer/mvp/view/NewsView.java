package com.rc.graduation.seer.mvp.view;

import com.rc.graduation.seer.mvp.model.entity.netease.NewsChannelTable;
import com.rc.graduation.seer.mvp.base.BaseView;

import java.util.List;

/**
 *   @version 1.0
 *   @author  rosen
 * Created by Administrator on 2016/10/19 0019.
 */
public interface NewsView extends BaseView {

    void initViewPager(List<NewsChannelTable> newsChannels);

}
