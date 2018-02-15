package com.view9.couriercustomer.ui.activities.splash.mvp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.view9.couriercustomer.R;
import com.view9.couriercustomer.ui.activities.trace.TraceActivity;


@SuppressLint("ViewConstructor")
public class SplashView extends FrameLayout {


    final int pBarMax = 100;
    public Activity activity;
    public SharedPreferences sharedPreferencesN;
    int progress = 0;

    public SplashView(@NonNull Activity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.splash, this);
        sharedPreferencesN = PreferenceManager.getDefaultSharedPreferences(activity);

//        AppUtils.transparentStatusBar(activity.getWindow());


    }

    public void startTrace() {
        TraceActivity.start(activity);
        activity.finish();
    }




}
