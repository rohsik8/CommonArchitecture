package com.view9.couriercustomer.ui.activities.trace.dagger;


import android.app.Activity;


import com.view9.couriercustomer.application.networkModels.CourierCustomerNetwork;
import com.view9.couriercustomer.ext.storage.PreferencesManager;
import com.view9.couriercustomer.ui.activities.trace.mvp.TraceModel;
import com.view9.couriercustomer.ui.activities.trace.mvp.TracePresenter;
import com.view9.couriercustomer.ui.activities.trace.mvp.TraceView;

import dagger.Module;
import dagger.Provides;

@Module
public class TraceModule {

    private final Activity activity;

    public TraceModule(Activity activity) {
        this.activity = activity;
    }

    @TraceScope
    @Provides
    TraceView loginView() {
        return new TraceView(activity);
    }


    @TraceScope
    @Provides
    TraceModel loginModel(PreferencesManager preferencesManager, CourierCustomerNetwork courierNetwork) {
        return new TraceModel(activity, preferencesManager, courierNetwork);
    }

    @TraceScope
    @Provides
    TracePresenter loginPresenter(TraceView traceView, TraceModel traceModel, PreferencesManager preferencesManager) {
        return new TracePresenter(traceView, traceModel, preferencesManager);
    }

}
