package com.view9.couriercustomer.ui.activities.splash.mvp;


import android.app.Activity;

import com.view9.couriercustomer.ext.storage.PreferencesManager;


public class SplashModel {

    private final Activity activity;
    private final PreferencesManager preferencesManager;

    public SplashModel(Activity activity, PreferencesManager preferencesManager) {
        this.activity = activity;
        this.preferencesManager = preferencesManager;
    }


//    public void startDashboard() {
//       HomePageActivity.start(activity);
//        activity.finish();
//    }
//
//    public void startTutorial() {
//        TutorialActivity.start(activity);
//        activity.finish();
//    }
    public void saveData(String key, String value) {
        preferencesManager.save(key, value);
    }


    public String getData(String key) {
        return preferencesManager.get(key);
    }


}
