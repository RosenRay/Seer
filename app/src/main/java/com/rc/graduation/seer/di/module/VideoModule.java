package com.rc.graduation.seer.di.module;

import com.rc.graduation.seer.di.scope.FragmentScope;
import com.rc.graduation.seer.mvp.model.apis.VideoModuleApiIml;
import com.rc.graduation.seer.mvp.model.apis.interfaces.VideoModuleApi;
import com.rc.graduation.seer.mvp.view.VideoView;

import dagger.Module;
import dagger.Provides;

/** @version    1.1.0
 *  @author     rosen
 * Created by Administrator on 2016/12/29 0029.
 */
@Module
public class VideoModule {

    private VideoView mView;

    public VideoModule(VideoView view) {
        this.mView = view;
    }

    @FragmentScope
    @Provides
    VideoView  provideVideoView(){
        return mView;
    }

    @FragmentScope
    @Provides
    VideoModuleApi  provideVideoModuleApi(){
        return new VideoModuleApiIml();
    }
}
