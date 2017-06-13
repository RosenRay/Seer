package com.rc.graduation.seer.mvp.presenter;

import com.socks.library.KLog;
import com.rc.graduation.seer.di.scope.ActivityScope;
import com.rc.graduation.seer.mvp.model.apis.interfaces.NewsModuleApi;
import com.rc.graduation.seer.mvp.model.entity.netease.NewsDetail;
import com.rc.graduation.seer.mvp.presenter.interfaces.NewsDetailPresenter;
import com.rc.graduation.seer.mvp.view.NewsDetailView;

import javax.inject.Inject;

/**
 * @version 1.0
 * Created by rosen on 2016/11/15 0015.
 */
@ActivityScope
public class NewsDetailPresenterImpl extends BasePresenterImpl<NewsDetailView,NewsModuleApi,NewsDetail> implements NewsDetailPresenter{

    private final String TAG = "NewsDetailPresenterImpl";

    private String mPostId;

    @Inject
    public NewsDetailPresenterImpl(NewsDetailView rootView,NewsModuleApi newsModuleApi){
        super(rootView,newsModuleApi);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        loadNewsDetail();
    }

    @Override
    public void setPostId(String postId) {
        mPostId = postId;
    }

    @Override
    public void success(NewsDetail data) {
        super.success(data);
        KLog.d(TAG,data.toString());
        mView.showNewsContent(data);
    }

    @Override
    public void onError(String errorMsg) {
        super.onError(errorMsg);
    }

    public void loadNewsDetail(){
        mSubscription = mApi.getNewsDetail(this,mPostId);
    }
}
