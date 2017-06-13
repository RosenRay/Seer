package com.rc.graduation.seer.mvp.view;

import com.rc.graduation.seer.mvp.model.entity.videos.VideoData;
import com.rc.graduation.seer.mvp.base.BaseView;

import java.util.List;

/**
 *  MVP V
 * Created by rosen on 2016/10/24 0024.
 */
public interface VideoListView extends BaseView{

    void setVideoList(List<VideoData> videoDataList, int loadType);

    void updateErrorView(int loadType);
}
