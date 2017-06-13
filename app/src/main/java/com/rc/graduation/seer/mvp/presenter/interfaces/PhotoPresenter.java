package com.rc.graduation.seer.mvp.presenter.interfaces;

/**
 * @version 1.0
 * @author  rosen
 * Created by Administrator on 2016/11/29.
 */

public interface PhotoPresenter extends BasePresenter {

    void loadPhotoData();

    void refreshData();

    void loadMore();
}
