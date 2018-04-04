package com.view9.couriercustomer.ui.activities.trace.mvp;


import android.app.Activity;


import com.view9.couriercustomer.application.networkModels.CourierCustomerNetwork;
import com.view9.couriercustomer.ext.storage.PreferencesManager;
import com.view9.couriercustomer.ui.activities.trace.TraceParams;


import io.reactivex.Observable;

public class TraceModel {

    private final Activity activity;
    private final PreferencesManager preferencesManager;
    private final CourierCustomerNetwork courierNetwork;

    public TraceModel(Activity activity, PreferencesManager preferencesManager, CourierCustomerNetwork courierNetwork) {
        this.activity = activity;
        this.preferencesManager = preferencesManager;
        this.courierNetwork = courierNetwork;
    }


    public void saveData(String key, String value) {
        preferencesManager.save(key, value);
    }


    public String getData(String key) {
        return preferencesManager.get(key);
    }


}
