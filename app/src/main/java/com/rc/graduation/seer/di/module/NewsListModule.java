package com.rc.graduation.seer.di.module;

import com.rc.graduation.seer.di.scope.FragmentScope;
import com.rc.graduation.seer.mvp.model.apis.NewsModuleApiImpl;
import com.rc.graduation.seer.mvp.model.apis.interfaces.NewsModuleApi;
import com.rc.graduation.seer.mvp.view.NewsListView;

import dagger.Module;
import dagger.Provides;

/** @version    1.1.0
 *  @author     rosen
 * Created by Administrator on 2016/12/29 0029.
 */
@Module
public class NewsListModule {

    private NewsListView    mView;

    public NewsListModule(NewsListView view){
        mView = view;
    }

    @FragmentScope
    @Provides
    NewsListView provideNewsListView(){
        return mView;
    }

    @FragmentScope
    @Provides
    NewsModuleApi  provideNewsModuleApi(){
        return new NewsModuleApiImpl();
    }

}
