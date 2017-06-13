package com.rc.graduation.seer.mvp.view;

import com.rc.graduation.seer.mvp.model.entity.videos.VideoChannel;
import com.rc.graduation.seer.mvp.base.BaseView;

import java.util.List;

/**
 * @version 1.0
 * @author  rosen
 * Created by Administrator on 2016/11/26.
 */

public interface VideoView extends BaseView {

    void initViewPager(List<VideoChannel> videoChannelList);

}
