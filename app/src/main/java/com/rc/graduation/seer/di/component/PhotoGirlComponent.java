package com.rc.graduation.seer.di.component;

import com.rc.graduation.seer.di.module.PhotoModule;
import com.rc.graduation.seer.di.scope.FragmentScope;
import com.rc.graduation.seer.mvp.ui.fragments.PhotoFragment;

import dagger.Component;

/** @version    1.0
 *  @author     rosen
 * Created by Administrator on 2016/12/29 0029.
 */

@FragmentScope
@Component(modules = PhotoModule.class,dependencies = AppComponent.class)
public interface PhotoGirlComponent {
    void inject(PhotoFragment fragment);
}
