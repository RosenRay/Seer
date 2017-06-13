package com.rc.graduation.seer.di.module;

import com.rc.graduation.seer.di.scope.ActivityScope;
import com.rc.graduation.seer.mvp.model.apis.NewsModuleApiImpl;
import com.rc.graduation.seer.mvp.model.apis.interfaces.NewsModuleApi;
import com.rc.graduation.seer.mvp.view.NewsDetailView;

import dagger.Module;
import dagger.Provides;

/** @version    1.1.0
 *  @author     rosen
 * Created by Administrator on 2016/12/29 0029.
 */

@Module
public class NewsDetailModule {

    private NewsDetailView  mView;

    public NewsDetailModule(NewsDetailView view) {
        this.mView = view;
    }

    @ActivityScope
    @Provides
    NewsDetailView provideNewsDetailView(){
        return mView;
    }

    @ActivityScope
    @Provides
    NewsModuleApi provideNewsModuleApi(){
        return new NewsModuleApiImpl();
    }
}
