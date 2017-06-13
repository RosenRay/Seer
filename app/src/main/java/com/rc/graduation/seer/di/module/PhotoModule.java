package com.rc.graduation.seer.di.module;

import com.rc.graduation.seer.di.scope.FragmentScope;
import com.rc.graduation.seer.mvp.model.apis.PhotoModuleApiImpl;
import com.rc.graduation.seer.mvp.model.apis.interfaces.PhotoModuleApi;
import com.rc.graduation.seer.mvp.view.PhotoGirlView;

import dagger.Module;
import dagger.Provides;

/** @version    1.1.0
 *  @author     rosen
 * Created by Administrator on 2016/12/29 0029.
 */
@Module
public class PhotoModule {

    private PhotoGirlView mView;

    /**
     * 构建 NewsModule时，将View的实现类传进来,这样就可以提供View的实现类给presenter
     * @param view
     */
    public PhotoModule(PhotoGirlView view){
        mView = view;
    }

    @FragmentScope
    @Provides
    PhotoGirlView providePhotoView(){
        return mView;
    }

    @FragmentScope
    @Provides
    PhotoModuleApi providePhotoApi(){
        return new PhotoModuleApiImpl();
    }
}
