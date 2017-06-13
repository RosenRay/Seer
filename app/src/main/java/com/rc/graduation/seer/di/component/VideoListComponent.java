package com.rc.graduation.seer.di.component;

import com.rc.graduation.seer.di.module.VideoListModule;
import com.rc.graduation.seer.di.scope.FragmentScope;
import com.rc.graduation.seer.mvp.ui.fragments.VideoListFragment;

import dagger.Component;

/**
 * @version     1.1.0
 * @author      rosen
 * Created by Administrator on 2016/12/29 0029.
 */

@FragmentScope
@Component(modules = VideoListModule.class,dependencies = AppComponent.class)
public interface VideoListComponent {

    void inject(VideoListFragment fragment);

}
