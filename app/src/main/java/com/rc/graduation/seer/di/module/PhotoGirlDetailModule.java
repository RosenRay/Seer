package com.rc.graduation.seer.di.module;

import com.rc.graduation.seer.di.scope.ActivityScope;
import com.rc.graduation.seer.mvp.model.apis.PhotoModuleApiImpl;
import com.rc.graduation.seer.mvp.model.apis.interfaces.PhotoModuleApi;
import com.rc.graduation.seer.mvp.view.PhotoDetailView;

import dagger.Module;
import dagger.Provides;

/** @version    1.1.0
 *  @author     rosen
 * Created by Administrator on 2016/12/29 0029.
 */

@Module
public class PhotoGirlDetailModule {

    private PhotoDetailView mView;

    public PhotoGirlDetailModule(PhotoDetailView view) {
        this.mView = view;
    }

    @ActivityScope
    @Provides
    PhotoDetailView providePhotoGirlDetailView(){
        return mView;
    }

    @ActivityScope
    @Provides
    PhotoModuleApi providePhotoModuleApi(){
        return new PhotoModuleApiImpl();
    }
}
