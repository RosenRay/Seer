package com.rc.graduation.seer.mvp.presenter.interfaces;

import com.rc.graduation.seer.mvp.model.entity.netease.NewsChannelTable;

/**
 *
 * @version 1.0
 * @author  rosen
 * Created by Administrator on 2016/11/22.
 */

public interface NewsChannelPresenter extends BasePresenter{

    void onItemSwap(int fromPosition,int toPosition);

    void onItemAddOrRemove(NewsChannelTable newsChannel,boolean isChannelMine);

    void selectIndex(String newsChannelId);
}
