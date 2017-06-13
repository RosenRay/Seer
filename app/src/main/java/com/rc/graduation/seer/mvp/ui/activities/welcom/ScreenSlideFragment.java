package com.rc.graduation.seer.mvp.ui.activities.welcom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rc.graduation.seer.R;

/**
 * Created by RosenRay on 2017/4/20.
 * 项目名 YahooNewsOnboarding-master
 * 类名   ScreenSlideFragment
 * 描述:
 */

public class ScreenSlideFragment extends Fragment {


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		Bundle args = getArguments();
		int position = args.getInt("position");
		int layoutId = getLayoutId(position);
		WelcomActivity welcomActivity = (WelcomActivity) getActivity();


		ViewGroup rootView = (ViewGroup) inflater.inflate(layoutId, container, false);
		if (position == 0) {

			welcomActivity.initFirstScreenViews(rootView, savedInstanceState);
		}
		if (position == 1) {

			welcomActivity.initSecondScreenViews(rootView, savedInstanceState);
		}
		if (position == 2) {

			welcomActivity.initThirdScreenViews(rootView, savedInstanceState);
		}

		return rootView;
	}

	private int getLayoutId(int position) {

		int id = 0;
		if (position == 0) {

			id = R.layout.first_screen;

		} else if (position == 1) {

			id = R.layout.second_screen;
		} else if (position == 2) {

			id = R.layout.third_screen;
		}
		return id;
	}


}

