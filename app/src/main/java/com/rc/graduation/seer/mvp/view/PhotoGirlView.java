package com.rc.graduation.seer.mvp.view;

import com.rc.graduation.seer.mvp.model.entity.photos.PhotoGirl;
import com.rc.graduation.seer.mvp.base.BaseView;

import java.util.List;

/**
 * @version 1.0
 * @author  rosen
 * Created by Administrator on 2016/11/29.
 */

public interface PhotoGirlView extends BaseView{

    void updateListView(List<PhotoGirl> photoGirlList,int loadType);

    void updateErrorView(int loadType);
}
