package com.rc.graduation.seer.mvp.ui.activities;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.rc.graduation.seer.R;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class SplashActivity extends AppCompatActivity {

	private static final int RP_WRITE = 2;

	private static final int ANIMATION_DURATION = 2000;
	private static final float SCALE_END = 1.13F;
	private String[] word = {"彼此正少年，莫负好时光", "能阻碍你的只有创意", "不要停止对这个世界抱有好奇"
			, "你的双手，有改变世界的力量", "佛为心，道为骨，儒为表","我本微末凡尘，依然心向天空", "现在过的每一天都是余生中最年轻的一天", "理性地奋斗，诗意地生活", "在路上，我们永远年轻，永远热泪盈眶"};
	private static final int[] SPLASH_ARRAY = {
			R.drawable.splash0,
			R.drawable.splash1,
			R.drawable.splash2,
			R.drawable.splash3,
			R.drawable.splash4,

			R.drawable.splash6,
			R.drawable.splash7,
			R.drawable.splash8,
			R.drawable.splash9,
			R.drawable.splash10,
			R.drawable.splash11,
			R.drawable.splash12,
			R.drawable.splash13,
			R.drawable.splash14,
			R.drawable.splash15,
			R.drawable.splash16,
	};

	@BindView(R.id.iv_splash)
	ImageView mIvSplash;

	@BindView(R.id.splash_app_name)
	TextView mSplashAppName;
	@BindView(R.id.splash_slogan)
	TextView mSplashSlogan;
	@BindView(R.id.splash_version_name)
	TextView mSplashVersionName;
	@BindView(R.id.splash_copyright)
	TextView mSplashCopyright;
	@BindView(R.id.splash_slogan_word)
	TextView splashSloganWord;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.zoomin, 0);
		setContentView(R.layout.activity_splash1);
		ButterKnife.bind(this);
		int index = (int)(Math.random()*(word.length - 1));//获取一个随机数
		splashSloganWord.setText(word[index]);
		if (toCheckPermission()) {
			initAnimation();
		}


	}

	/**
	 * 检查权限是否通过
	 */
	private boolean toCheckPermission() {
		int result = ActivityCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
		if (PERMISSION_GRANTED != result) {
			ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, RP_WRITE);
			return false;
		}
		return true;
	}

	/**
	 * 弹框显示缺少权限
	 */
	private void showDialog(boolean isReTry) {
		AlertDialog.Builder builder = new AlertDialog
				.Builder(this)
				.setTitle("SD卡读写权限缺少")
				.setMessage("应用的基础数据本地初始化时，需要SD卡的读写权限，否则将无法正常使用本应用。\n 可通过'设置' -> '应用程序'->'权限设置'，重新设置应用权限。")
				.setNegativeButton("退出应用", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						finish();
					}
				});
		if (isReTry) {
			builder.setPositiveButton("重新授权", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
					toCheckPermission();
				}
			});
		}
		builder.create().show();
	}


	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		if (RP_WRITE == requestCode) {
			if (grantResults[0] == PERMISSION_GRANTED) {
				//TODO continue
				initAnimation();
			} else {
				//TODO show dialog to user
				//判断用户是否勾选 不再询问的选项，未勾选可以 说明权限作用，重新授权。
				boolean shouldShow = ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
				if (shouldShow) {
					showDialog(true);
				} else {
					showDialog(false);
				}
			}
		} else {
			super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		}
	}

	private void initAnimation() {
		Random r = new Random(SystemClock.elapsedRealtime());
		mIvSplash.setImageResource(SPLASH_ARRAY[r.nextInt(SPLASH_ARRAY.length)]);
		animateImage();
	}

	private void animateImage() {
		ObjectAnimator animatorX = ObjectAnimator.ofFloat(mIvSplash, "scaleX", 1f, SCALE_END);
		ObjectAnimator animatorY = ObjectAnimator.ofFloat(mIvSplash, "scaleY", 1f, SCALE_END);

		AnimatorSet set = new AnimatorSet();
		set.setDuration(ANIMATION_DURATION).play(animatorX).with(animatorY);
		set.start();

		set.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
//                HomeActivity.start(SplashActivity.this);
//                SplashActivity.this.finish();
				finishActivity();
			}
		});
	}

	private void finishActivity() {
		Observable.timer(1000, TimeUnit.MILLISECONDS)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Action1<Long>() {
					@Override
					public void call(Long aLong) {
						startActivity(new Intent(SplashActivity.this, HomeActivity.class));
						overridePendingTransition(0, android.R.anim.fade_out);
						finish();
					}
				});
	}
}
