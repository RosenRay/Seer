package com.rc.graduation.seer.di.component;

import com.rc.graduation.seer.di.module.VideoModule;
import com.rc.graduation.seer.di.scope.FragmentScope;
import com.rc.graduation.seer.mvp.ui.fragments.VideoFragment;

import dagger.Component;

/** @version    1.1.0
 *  @author     rosen
 * Created by Administrator on 2016/12/29 0029.
 */
@FragmentScope
@Component(modules = VideoModule.class,dependencies = AppComponent.class)
public interface VideoComponent {

    void inject(VideoFragment fragment);

}
