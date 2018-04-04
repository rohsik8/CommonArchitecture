package com.view9.couriercustomer.ui.activities.OrderStatus.dagger;


import android.support.v7.app.AppCompatActivity;


import com.view9.couriercustomer.application.networkModels.CourierCustomerNetwork;
import com.view9.couriercustomer.ext.storage.PreferencesManager;
import com.view9.couriercustomer.ui.activities.OrderStatus.OrderAdapter;
import com.view9.couriercustomer.ui.activities.OrderStatus.mvp.OrderModel;
import com.view9.couriercustomer.ui.activities.OrderStatus.mvp.OrderPresenter;
import com.view9.couriercustomer.ui.activities.OrderStatus.mvp.OrderView;

import dagger.Module;
import dagger.Provides;

@Module
public class OrderModule {

    private final AppCompatActivity activity;

    public OrderModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @OrderScope
    @Provides
    public OrderView manifestView(PreferencesManager preferencesManager, OrderAdapter orderAdapter) {
        return new OrderView(activity, preferencesManager, orderAdapter);
    }

    @OrderScope
    @Provides
    public OrderModel manifestModel(CourierCustomerNetwork courierNetwork, PreferencesManager preferencesManager) {
        return new OrderModel(activity, courierNetwork, preferencesManager);
    }

    @OrderScope
    @Provides
    public OrderPresenter manifestPresenter(OrderView orderView, OrderModel orderModel) {
        return new OrderPresenter(orderView, orderModel);
    }

    @OrderScope
    @Provides
    public OrderAdapter manifestAdapter() {
        return new OrderAdapter();
    }
   /* @DiscoverScope
    @Provides
    public FitnessUtils fitnessUtils()
    {
        return new FitnessUtils(activity);
    }*/


}
