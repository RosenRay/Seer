package com.rc.graduation.seer.di.module;

import com.rc.graduation.seer.di.scope.FragmentScope;
import com.rc.graduation.seer.mvp.model.apis.VideoModuleApiIml;
import com.rc.graduation.seer.mvp.model.apis.interfaces.VideoModuleApi;
import com.rc.graduation.seer.mvp.view.VideoListView;

import dagger.Module;
import dagger.Provides;

/** @version    1.1.0
 *  @author     rosen
 * Created by Administrator on 2016/12/29 0029.
 */
@Module
public class VideoListModule {

    private VideoListView mView;

    public VideoListModule(VideoListView view) {
        this.mView = view;
    }

    @FragmentScope
    @Provides
    VideoListView provideVideoListView(){
        return mView;
    }

    @FragmentScope
    @Provides
    VideoModuleApi provideVideoModuleApi(){
        return new VideoModuleApiIml();
    }
}
