package com.rc.graduation.seer.mvp.presenter.interfaces;

/**
 * @version 1.0
 * Created by rosen on 2016/11/10 0010.
 */
public interface NewsListPresenter extends BasePresenter {

    void setNewsTypeAndId(String newsType,String newsId);

    void firstLoadData();

    void refreshData();

    void loadMore();
}
