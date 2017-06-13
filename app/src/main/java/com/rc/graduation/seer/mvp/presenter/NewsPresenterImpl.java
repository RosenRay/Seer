package com.rc.graduation.seer.mvp.presenter;

import com.rc.graduation.seer.di.scope.FragmentScope;
import com.rc.graduation.seer.mvp.model.apis.interfaces.NewsModuleApi;
import com.rc.graduation.seer.mvp.model.entity.netease.NewsChannelTable;
import com.rc.graduation.seer.mvp.presenter.interfaces.NewsPresenter;
import com.rc.graduation.seer.mvp.view.NewsView;

import java.util.List;

import javax.inject.Inject;

/**
 *  @version 1.0
 * Created by rosen on 2016/10/21 0021.
 */
@FragmentScope
public class NewsPresenterImpl extends BasePresenterImpl<NewsView,NewsModuleApi,List<NewsChannelTable>> implements NewsPresenter{

    @Inject
    public NewsPresenterImpl(NewsView rootView,NewsModuleApi api){
        super(rootView,api);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        loadNewsChannelFromDB();
    }

    @Override
    public void success(List<NewsChannelTable> data) {
        super.success(data);
        mView.initViewPager(data);
    }

    @Override
    public void loadNewsChannels() {
        loadNewsChannelFromDB();
    }

    private void loadNewsChannelFromDB(){
        mSubscription = mApi.loadNewsChannel(this);
    }
}
