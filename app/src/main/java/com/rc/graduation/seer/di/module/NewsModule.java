package com.rc.graduation.seer.di.module;

import com.rc.graduation.seer.di.scope.FragmentScope;
import com.rc.graduation.seer.mvp.model.apis.NewsModuleApiImpl;
import com.rc.graduation.seer.mvp.model.apis.interfaces.NewsModuleApi;
import com.rc.graduation.seer.mvp.view.NewsView;

import dagger.Module;
import dagger.Provides;

/** @version    1.1.0
 *  @author     rosen
 * Created by Administrator on 2016/12/29 0029.
 */
@Module
public class NewsModule {

    private NewsView mView;

    /**
     * 构建 NewsModule时，将View的实现类传进来,这样就可以提供View的实现类给presenter
     * @param view
     */
    public NewsModule(NewsView view){
        mView = view;
    }

    @FragmentScope
    @Provides
    NewsView provideNewsView(){
        return mView;
    }

    @FragmentScope
    @Provides
    NewsModuleApi provideNewsApi(){
        return new NewsModuleApiImpl();
    }
}
