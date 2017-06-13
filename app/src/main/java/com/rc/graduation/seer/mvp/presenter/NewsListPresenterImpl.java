package com.rc.graduation.seer.mvp.presenter;

import com.socks.library.KLog;
import com.rc.graduation.seer.common.LoadDataType;
import com.rc.graduation.seer.common.RequestCallBack;
import com.rc.graduation.seer.di.scope.FragmentScope;
import com.rc.graduation.seer.mvp.model.apis.interfaces.NewsModuleApi;
import com.rc.graduation.seer.mvp.model.entity.netease.NewsSummary;
import com.rc.graduation.seer.mvp.presenter.interfaces.NewsListPresenter;
import com.rc.graduation.seer.mvp.view.NewsListView;

import java.util.List;

import javax.inject.Inject;

/**
 * @version 1.0
 * Created by rosen on 2016/11/10 0010.
 */
@FragmentScope
public class NewsListPresenterImpl extends BasePresenterImpl<NewsListView,NewsModuleApi,List<NewsSummary>>
        implements NewsListPresenter,RequestCallBack<List<NewsSummary>>{

    private int mLoadDataType;
    private String mNewsType,mNewsId;
    private int mStartPage;

    @Inject
    public NewsListPresenterImpl(NewsListView rootView,NewsModuleApi newsModuleApi){
        super(rootView,newsModuleApi);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        KLog.d("WeixinListFragment","NewsListPresenterImpl");
        if(mView != null){
            firstLoadData();
        }
    }

    @Override
    public void success(List<NewsSummary> data) {
        super.success(data);
        mView.setNewsList(data,mLoadDataType);
    }

    @Override
    public void onError(String errorMsg) {
        super.onError(errorMsg);
        mView.updateErrorView(mLoadDataType);
    }

    @Override
    public void setNewsTypeAndId(String newsType, String newsId) {
        mStartPage = 0;
        mNewsType = newsType;
        mNewsId = newsId;
    }

    @Override
    public void firstLoadData() {
        beforeRequest();
        mLoadDataType = LoadDataType.TYPE_FIRST_LOAD;
        loadNewsData();
    }

    @Override
    public void refreshData() {
        mStartPage = 0;
        mLoadDataType = LoadDataType.TYPE_REFRESH;
        loadNewsData();
    }

    @Override
    public void loadMore() {
        mStartPage += 20;
        mLoadDataType = LoadDataType.TYPE_LOAD_MORE;
        loadNewsData();
    }

    public void loadNewsData(){
        mSubscription = mApi.loadNews(this,mNewsType,mNewsId,mStartPage);
    }
}
