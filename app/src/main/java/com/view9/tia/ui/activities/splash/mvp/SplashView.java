package com.view9.tia.ui.activities.splash.mvp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.view9.tia.R;


@SuppressLint("ViewConstructor")
public class SplashView extends FrameLayout {

    public Activity activity;
    public SharedPreferences sharedPreferencesN;


    public SplashView(@NonNull Activity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.splash, this);
        sharedPreferencesN = PreferenceManager.getDefaultSharedPreferences(activity);
    }


}
