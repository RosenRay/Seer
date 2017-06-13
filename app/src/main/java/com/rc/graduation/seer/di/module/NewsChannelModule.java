package com.rc.graduation.seer.di.module;

import com.rc.graduation.seer.di.scope.ActivityScope;
import com.rc.graduation.seer.mvp.model.apis.NewsChannelApiImpl;
import com.rc.graduation.seer.mvp.model.apis.interfaces.NewsChannelApi;
import com.rc.graduation.seer.mvp.view.NewsChannelView;

import dagger.Module;
import dagger.Provides;

/** @version    1.1.0
 *  @author     rosen
 * Created by Administrator on 2016/12/29 0029.
 */
@Module
public class NewsChannelModule {

    private NewsChannelView mView;

    public NewsChannelModule(NewsChannelView view){
        mView = view;
    }

    @ActivityScope
    @Provides
    NewsChannelView provideNewsChannelView(){
        return mView;
    }

    @ActivityScope
    @Provides
    NewsChannelApi  provideNewsChannelApi(){
        return new NewsChannelApiImpl();
    }

}
