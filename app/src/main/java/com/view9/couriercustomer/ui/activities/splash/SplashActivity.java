package com.view9.couriercustomer.ui.activities.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.view9.couriercustomer.application.dagger.CourierCustomerApplication;
import com.view9.couriercustomer.ui.activities.splash.dagger.DaggerSplashComponent;
import com.view9.couriercustomer.ui.activities.splash.dagger.SplashModule;
import com.view9.couriercustomer.ui.activities.splash.mvp.SplashPresenter;
import com.view9.couriercustomer.ui.activities.splash.mvp.SplashView;

import javax.inject.Inject;


public class SplashActivity extends AppCompatActivity {


    @Inject
    SplashView splashView;

    @Inject
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerSplashComponent.builder()
                .appComponent(CourierCustomerApplication.get(this).appComponent())
                .splashModule(new SplashModule(this))
                .build()
                .inject(this);
        setContentView(splashView);

//        AppUtils.transparentStatusBar(getWindow());
    }


    @Override
    protected void onResume() {
        super.onResume();
        splashPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashPresenter.onDestroy();
    }
}
