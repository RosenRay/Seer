package com.rc.graduation.seer.di.component;

import android.app.Activity;

import com.rc.graduation.seer.di.module.ActivityModule;
import com.rc.graduation.seer.di.scope.ActivityScope;

import dagger.Component;

/**
 * @version 1.0
 * @author   rosen
 * Created by Administrator on 2016/12/27 0027.
 */

@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();
}
