package com.rc.graduation.seer.mvp.ui.activities;

import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

import com.rc.graduation.seer.R;
import com.rc.graduation.seer.di.component.AppComponent;
import com.rc.graduation.seer.mvp.ui.activities.base.BaseActivity;

import butterknife.BindView;

public class AboutActivity extends BaseActivity {

    @BindView(R.id.app_about_text)
    TextView mAboutText;

    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews() {
        mAboutText.setAutoLinkMask(Linkify.ALL);
        mAboutText.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }
}
