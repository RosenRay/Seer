package com.rc.graduation.seer.di.component;

import com.rc.graduation.seer.di.module.ActivityModule;
import com.rc.graduation.seer.di.module.PhotoGirlDetailModule;
import com.rc.graduation.seer.di.scope.ActivityScope;
import com.rc.graduation.seer.mvp.ui.activities.PhotoDetailActivity;

import dagger.Component;

/**
 * @version 1.1.0
 * @author  rosen
 * Created by Administrator on 2016/12/29 0029.
 */
@ActivityScope
@Component(modules = {PhotoGirlDetailModule.class, ActivityModule.class},dependencies = AppComponent.class)
public interface PhotoGirlDetailComponent {

    void inject(PhotoDetailActivity activity);

}
