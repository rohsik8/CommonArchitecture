package com.view9.couriercustomer.application.dagger;


import android.content.Context;

import com.squareup.picasso.Picasso;
import com.view9.couriercustomer.application.dagger.modules.AppModule;
import com.view9.couriercustomer.application.dagger.modules.GsonModule;
import com.view9.couriercustomer.application.dagger.modules.NetworkModule;
import com.view9.couriercustomer.application.networkModels.CourierCustomerNetwork;
import com.view9.couriercustomer.ext.storage.PreferencesManager;


import dagger.Component;
import okhttp3.OkHttpClient;

@AppScope
@Component(modules = {AppModule.class, GsonModule.class, NetworkModule.class})
public interface AppComponent {

    Context context();

    OkHttpClient okHttpClient();

    CourierCustomerNetwork vepNetwork();


    PreferencesManager preferencesManager();



    Picasso picasso();

}
