package com.view9.couriercustomer.ui.activities.OrderStatus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.view9.couriercustomer.application.dagger.CourierCustomerApplication;
import com.view9.couriercustomer.ui.activities.OrderStatus.dagger.DaggerOrderComponent;
import com.view9.couriercustomer.ui.activities.OrderStatus.dagger.OrderModule;
import com.view9.couriercustomer.ui.activities.OrderStatus.mvp.OrderPresenter;
import com.view9.couriercustomer.ui.activities.OrderStatus.mvp.OrderView;
import com.view9.couriercustomer.utils.Constants;

import javax.inject.Inject;


public class OrderListActivity extends AppCompatActivity {

    @Inject
    OrderView orderView;

    @Inject
    OrderPresenter orderPresenter;

    public static String id="";

    public static void startManifestActivity(Context context){
        context.startActivity(new Intent(context, OrderListActivity.class));
    }
    @Nullable
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerOrderComponent.builder()
                .appComponent(CourierCustomerApplication.get(this).appComponent())
                .orderModule(new OrderModule(this))
                .build()
                .inject(this);
        if(getIntent()!=null){
            id = getIntent().getStringExtra(Constants.ID);
        }
        //setContentView(orderView);
        orderPresenter.onCreateView();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        orderPresenter.onDestroyView();

    }
    @Override
    public void onResume() {
        super.onResume();
        //HomePageView.currentFragment= orderPresenter.getPreference();

    }

}
