package com.rc.graduation.seer.di.component;

import com.rc.graduation.seer.di.module.NewsDetailModule;
import com.rc.graduation.seer.di.scope.ActivityScope;
import com.rc.graduation.seer.mvp.ui.activities.NewsDetailActivity;

import dagger.Component;

/**
 *  @version    1.1.0
 *  @author     rosen
 * Created by Administrator on 2016/12/29 0029.
 */
@ActivityScope
@Component(modules = NewsDetailModule.class,dependencies = AppComponent.class)
public interface NewsDetailComponent {

    void inject(NewsDetailActivity activity);

}
