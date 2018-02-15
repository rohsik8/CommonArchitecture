package com.view9.couriercustomer.ui.activities.trace;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;


import com.view9.couriercustomer.application.dagger.CourierCustomerApplication;

import com.view9.couriercustomer.databinding.TraceLayoutBinding;
import com.view9.couriercustomer.ui.activities.trace.dagger.DaggerTraceComponent;
import com.view9.couriercustomer.ui.activities.trace.dagger.TraceModule;
import com.view9.couriercustomer.ui.activities.trace.mvp.TracePresenter;
import com.view9.couriercustomer.ui.activities.trace.mvp.TraceView;
import com.view9.couriercustomer.utils.GeneralUtils;

import javax.inject.Inject;


public class TraceActivity extends AppCompatActivity {


    @Inject
    TraceView traceView;

    @Inject
    TracePresenter tracePresenter;

    TraceLayoutBinding loginBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerTraceComponent.builder()
                .appComponent(CourierCustomerApplication.get(this).appComponent())
                .traceModule(new TraceModule(this))
                .build()
                .inject(this);

        String[] PERMISSIONS = { Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_SMS, Manifest.permission.CAMERA};

        if(!GeneralUtils.hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, 1);
        }
        tracePresenter.onCreate();


    }

    public static void start(Context context){
        context.startActivity(new Intent(context,TraceActivity.class));
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tracePresenter.onDestroy();
    }
}
