package com.rc.graduation.seer.mvp.presenter.interfaces;

/**
 * @version 1.0
 * @author  rosen
 * Created by Administrator on 2016/11/30.
 */

public interface PhotoDetailPresenter extends BasePresenter {

    //下载保存图片
    void savePhoto(String photoUrl);

    //分享图片
    void sharePhoto(String photoUrl);

    //设置墙纸
    void setWallpaper(String photoUrl);

}
