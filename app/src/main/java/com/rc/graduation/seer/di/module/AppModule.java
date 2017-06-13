package com.rc.graduation.seer.di.module;

import android.app.Application;

import com.rc.graduation.seer.MyApplication;
import com.rc.graduation.seer.common.AppManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *  @version 1.0
 *  @author  rosen
 * Created by Administrator on 2016/12/23 0023.
 */
@Module
public class AppModule {

    private MyApplication myApplication;
    private AppManager    mAppManager;

    public AppModule(MyApplication myApplication,AppManager appManager) {
        this.myApplication = myApplication;
        this.mAppManager = appManager;
    }

    @Singleton
    @Provides
    Application provideApplication(){
        return myApplication;
    }

    @Singleton
    @Provides
    AppManager provideAppManager(){
        return mAppManager;
    }

}
