package com.view9.couriercustomer.ui.activities.login;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;


import com.view9.couriercustomer.application.dagger.CourierCustomerApplication;
import com.view9.couriercustomer.databinding.LoginBinding;
import com.view9.couriercustomer.ui.activities.login.dagger.DaggerLoginComponent;
import com.view9.couriercustomer.ui.activities.login.dagger.LoginModule;
import com.view9.couriercustomer.ui.activities.login.mvp.LoginPresenter;
import com.view9.couriercustomer.ui.activities.login.mvp.LoginView;
import com.view9.couriercustomer.utils.GeneralUtils;

import javax.inject.Inject;


public class LoginActivity extends AppCompatActivity {


    @Inject
    LoginView loginView;

    @Inject
    LoginPresenter loginPresenter;

    LoginBinding loginBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerLoginComponent.builder()
                .appComponent(CourierCustomerApplication.get(this).appComponent())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

        String[] PERMISSIONS = { Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_SMS, Manifest.permission.CAMERA};

        if(!GeneralUtils.hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, 1);
        }
        loginPresenter.onCreate();


    }

    public static void start(Context context){
        context.startActivity(new Intent(context,LoginActivity.class));
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }
}
