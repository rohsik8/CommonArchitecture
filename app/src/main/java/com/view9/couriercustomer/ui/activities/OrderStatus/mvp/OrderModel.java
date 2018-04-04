package com.view9.couriercustomer.ui.activities.OrderStatus.mvp;

import android.support.v7.app.AppCompatActivity;


import com.view9.couriercustomer.application.networkModels.CourierCustomerNetwork;
import com.view9.couriercustomer.ext.storage.PreferencesManager;
import com.view9.couriercustomer.ui.activities.OrderStatus.OrderParams;
import com.view9.couriercustomer.ui.activities.OrderStatus.orderResponse.OrderResponse;
import com.view9.couriercustomer.utils.Constants;

import io.reactivex.Observable;


public class OrderModel {

    private final CourierCustomerNetwork courierNetwork;
    private AppCompatActivity activity;
    PreferencesManager preferencesManager;


    public OrderModel(AppCompatActivity activity, CourierCustomerNetwork courierNetwork, PreferencesManager preferencesManager) {
        this.activity = activity;
        this.courierNetwork = courierNetwork;
        this.preferencesManager = preferencesManager;

    }




    public Observable<OrderResponse> getOrderObservable(int page, OrderParams orderParams) {

       // String url = Constants.TRACKING+"?page="+page;
        String url = Constants.TRACKING;
        return courierNetwork.getTrackingObservable(url, orderParams);
    }

    public String getData(String key) {
        return preferencesManager.get(key);
    }

    public void saveData(String key, String value) {
        preferencesManager.save(key, value);
    }

}


