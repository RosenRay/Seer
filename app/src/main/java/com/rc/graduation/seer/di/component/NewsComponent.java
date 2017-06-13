package com.rc.graduation.seer.di.component;

import com.rc.graduation.seer.di.module.NewsModule;
import com.rc.graduation.seer.di.scope.FragmentScope;
import com.rc.graduation.seer.mvp.ui.fragments.News.NewsFragment;

import dagger.Component;

/** @version    1.0
 *  @author     rosen
 * Created by Administrator on 2016/12/29 0029.
 */

@FragmentScope
@Component(modules = NewsModule.class,dependencies = AppComponent.class)
public interface NewsComponent {
    void inject(NewsFragment fragment);
}
