package com.rc.graduation.seer.mvp.ui.fragments;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rc.graduation.seer.R;
import com.rc.graduation.seer.di.component.AppComponent;
import com.rc.graduation.seer.mvp.model.entity.weixin.WeixinList;
import com.rc.graduation.seer.mvp.ui.activities.HomeActivity;
import com.rc.graduation.seer.mvp.ui.activities.WeixinDetailActivity;
import com.rc.graduation.seer.mvp.ui.adapters.RecyclerItemClickListener;
import com.rc.graduation.seer.mvp.ui.adapters.WeixinListAdapter;
import com.rc.graduation.seer.mvp.ui.fragments.base.BaseFragment;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.rc.graduation.seer.R.id.toolbar;

/**
 * @author rosen
 * @version 1.0
 */
public class WeixinFragment extends BaseFragment {
	@BindView(toolbar)
	Toolbar mToolbar;

	@BindView(R.id.swipe_refresh_layout)
	SwipeRefreshLayout mSwipeRefreshLayout;

	@BindView(R.id.recycler_view)
	RecyclerView mWeixinRecyclerView;

	@BindView(R.id.empty_view)
	TextView mEmptyView;

	@BindView(R.id.progress_bar)
	ProgressBar mProgressBar;
	private HomeActivity activity;
	private DrawerLayout mDrawerLayout;
	private NavigationView mNavigationView;
	private OkHttpClient client;
	private WeixinList weixinList;
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case 1:
					mProgressBar.setVisibility(View.INVISIBLE);
					list = (WeixinList) msg.obj;
					initRecyclerView();
					break;
				case 2:
					WeixinList obj = (WeixinList) msg.obj;
					mAdapter.addMore(obj.getResult().getList());
					break;
			}
		}
	};
	private WeixinListAdapter mAdapter;
	private WeixinList list;
	private String ps;
	private String pno = "1";
	//请求的页数
	private String url;

	@OnClick({R.id.empty_view, R.id.fab})
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.empty_view:
//                mPresenter.loadPhotoData();
				break;
			case R.id.fab:
				mWeixinRecyclerView.getLayoutManager().scrollToPosition(0);
				break;
		}
	}

	//配置您申请的KEY
	public static final String APPKEY = "f1c08ab5477b1fb0fa69fccdb0af3186";


	private static final String TAG = "WeixinFragment";
	private boolean isLoading = false;

/*    @Override
	public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPhotoFIListener) {
            mListener = (OnPhotoFIListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

	@Override
	public void onDetach() {
		super.onDetach();
//        mListener = null;
	}

	//微信精选列表
	public void getRequest() {
		String result = null;
		//请求参数
		//每页多少条数据
		ps = "";
		url = "http://v.juhe.cn/weixin/query" + "?pno=" + pno + "&ps=" + ps + "&dtype=&key=" + APPKEY;
		Request request = new Request.Builder().url(url).build();
		client = new OkHttpClient();
		client.newCall(request).enqueue(new Callback() {


			@Override
			public void onFailure(Call call, IOException e) {

			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String string = response.body().string();
				System.out.println(string);
				Gson gson = new Gson();
				weixinList = gson.fromJson(string, WeixinList.class);
				Message msg = Message.obtain();
				msg.obj = weixinList;
				if (Integer.parseInt(pno) == 1) {
					msg.what = 1;
				} else {
					msg.what = 2;
				}
				handler.sendMessage(msg);
			}
		});
	}

	private void initRecyclerView() {

		mWeixinRecyclerView.setHasFixedSize(true);
		LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
		mWeixinRecyclerView.setLayoutManager(mLayoutManager);
		mWeixinRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
			@Override
			public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
				outRect.set(10, 10, 10, 10);
//                super.getItemOffsets(outRect, view, parent, state);
			}
		});
		if (list != null) {
			mAdapter = new WeixinListAdapter(list.getResult().getList(), mApplication);

			mWeixinRecyclerView.setItemAnimator(new DefaultItemAnimator());

			mAdapter.setOnItemClickListener(this);
			mWeixinRecyclerView.setAdapter(mAdapter);
		}
		mSwipeRefreshLayout.setRefreshing(false);
	}

	@Override
	protected void setupFragmentComponent(AppComponent appComponent) {
		/*DaggerPhotoGirlComponent.builder()
				.appComponent(appComponent)
                .photoModule(new PhotoModule(this))
                .build()
                .inject(this);*/
	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_photo;
	}

	@Override
	public void initViews(View view) {
//        mListener.onWeixinToolbar(mToolbar);
		activity = (HomeActivity) getActivity();
		mDrawerLayout = activity.mDrawerLayout;
		mNavigationView = activity.mNavigationView;
		activity.setSupportActionBar(mToolbar);
		mToolbar.setTitle("微信精选");
		Log.d(TAG, "initViews: jhlfd");
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				activity, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		mDrawerLayout.setDrawerListener(toggle);
		toggle.syncState();
		mToolbar.setNavigationIcon(R.mipmap.ic_arrow_back);
//        mNavigationView.setNavigationItemSelectedListener(activity);
		initSwipeRefreshLayout();
		initRecyclerView();
		getRequest();
		mWeixinRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
				super.onScrollStateChanged(recyclerView, newState);
				RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

				int lastVisibleItemPosition = ((LinearLayoutManager) layoutManager)
						.findLastVisibleItemPosition();
				int visibleItemCount = layoutManager.getChildCount();
				int totalItemCount = layoutManager.getItemCount();

				if (!isLoading && visibleItemCount > 0 && newState == RecyclerView.SCROLL_STATE_IDLE
						&& lastVisibleItemPosition >= totalItemCount - 1) {
					//TODO load more % show footer
					isLoading = true;
					if (mAdapter != null) {
						mAdapter.showFooter();
					}
					pno = Integer.parseInt(pno) + 1 + "";
					getRequest();
//                    mAdapter.addMore();
//                    mWeixinRecyclerView.setAdapter(mAdapter);
//                    mWeixinRecyclerView.scrollToPosition(mAdapter.getItemCount() - 1);
				}
			}

			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
				super.onScrolled(recyclerView, dx, dy);
			}
		});
		mWeixinRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), mWeixinRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
				Intent intent = new Intent(getContext(), WeixinDetailActivity.class);
				intent.putExtra("weixinUrl", weixinList.getResult().getList().get(position).getUrl());
				intent.putExtra("title", weixinList.getResult().getList().get(position).getTitle());
				intent.putExtra("pic", weixinList.getResult().getList().get(position).getFirstImg());
				System.out.println(weixinList.getResult().getList().get(position).getTitle() + "  " + weixinList.getResult().getList().get(position).getUrl());
				getContext().startActivity(intent);
			}

			@Override
			public void onItemLongClick(View view, int position) {

			}
		}));
	}

	@Override
	protected void initData() {
//        mPresenter.onCreate();

	}

	private void initSwipeRefreshLayout() {
		mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light, android.R.color.holo_blue_light);
		mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				//TODO refresh data
//                mPresenter.refreshData();
				mWeixinRecyclerView.setAdapter(mAdapter);
				mSwipeRefreshLayout.setRefreshing(false);

			}
		});
	}





   /* private OnWeixinFIListener mListener;

    public interface OnWeixinFIListener {
        void onWeixinToolbar(Toolbar toolbar);
    }*/
}
