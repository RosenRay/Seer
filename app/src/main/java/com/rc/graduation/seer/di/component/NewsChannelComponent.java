package com.rc.graduation.seer.di.component;

import com.rc.graduation.seer.di.module.NewsChannelModule;
import com.rc.graduation.seer.di.scope.ActivityScope;
import com.rc.graduation.seer.mvp.ui.activities.NewsChannelActivity;

import dagger.Component;

/** @version    1.0
 *  @author     rosen
 * Created by Administrator on 2016/12/29 0029.
 */

@ActivityScope
@Component(modules = NewsChannelModule.class,dependencies = AppComponent.class)
public interface NewsChannelComponent {
    void inject(NewsChannelActivity activity);
}
