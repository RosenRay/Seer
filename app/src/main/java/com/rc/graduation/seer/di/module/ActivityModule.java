package com.rc.graduation.seer.di.module;

import android.app.Activity;

import com.rc.graduation.seer.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * @version 1.0
 * @author  rosen
 * Created by Administrator on 2016/12/27 0027.
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity){
        mActivity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity(){
        return mActivity;
    }

}
