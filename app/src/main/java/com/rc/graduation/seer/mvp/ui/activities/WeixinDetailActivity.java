package com.rc.graduation.seer.mvp.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.rc.graduation.seer.R;
import com.rc.graduation.seer.di.component.AppComponent;
import com.rc.graduation.seer.mvp.ui.activities.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.OkHttpClient;

public class WeixinDetailActivity extends BaseActivity{

    private static final String NEWS_POST_ID = "NEWS_POST_ID";
    private static final String NEWS_IMG_RES = "NEWS_IMG_RES";

    private String mPostId;
    private String mShareLink;
    private String  mWeixinTitle;

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.weixin_detail_picture_iv)
    ImageView weixinDetailPictureIv;
    private OkHttpClient client;
    private WebView webView;

    @OnClick(R.id.fab)
    public void onClick(View v){
        if(v.getId() == R.id.fab){
            share();
        }
    }

    public static Intent getNewsDetailIntent(Context context, String postId, String postImgPath){
        Intent intent = new Intent(context,WeixinDetailActivity.class);
        intent.putExtra(NEWS_POST_ID,postId);
        intent.putExtra(NEWS_IMG_RES,postImgPath);
        return intent;
    }

    private void share() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share));
        intent.putExtra(Intent.EXTRA_TEXT, getShareContents());
        startActivity(Intent.createChooser(intent, getTitle()));
    }

    @NonNull
    private String getShareContents() {
        if (mShareLink == null) {
            mShareLink = "";
        }
        return getString(R.string.share_contents, mWeixinTitle, mShareLink);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_weixin_detail;
    }

    @Override
    public void initVariables() {

    }


    @Override
    public void initViews() {
        webView = (WebView) findViewById(R.id.web_view);
        webView.setWebViewClient(new MyWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);//启用js
        webView.getSettings().setBlockNetworkImage(false);//解决图片不显示
        toolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.title_color));
        toolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.title_color));
        loadView();
    }
    public void loadView() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("weixinUrl");
        mWeixinTitle = intent.getStringExtra("title");
        String pic = intent.getStringExtra("pic");
        mShareLink = url;
        toolbarLayout.setTitle(mWeixinTitle);
        System.out.println(url);
        webView.loadUrl(url);
        Glide.with(this).load(pic).asBitmap()
                .placeholder(R.mipmap.ic_loading)
                .format(DecodeFormat.PREFER_ARGB_8888)
                .error(R.mipmap.ic_load_fail)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(weixinDetailPictureIv);

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        /*DaggerNewsDetailComponent.builder()
                .appComponent(appComponent)
                .newsDetailModule(new NewsDetailModule(this))
                .build()
                .inject(this);*/
    }

    @Override
    protected void initData() {

        if(mPresenter != null){
            mPresenter.onCreate();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_news_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}
