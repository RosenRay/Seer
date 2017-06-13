package com.rc.graduation.seer.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 *  @version 1.0
 *  @author   rosen
 * Created by Administrator on 2016/12/23 0023.
 */

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memorized in the
 * correct component.
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope { }
