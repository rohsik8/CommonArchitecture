package com.view9.tia.application.dagger;


import android.content.Context;

import com.squareup.picasso.Picasso;
import com.view9.tia.application.dagger.modules.AppModule;
import com.view9.tia.application.dagger.modules.GsonModule;
import com.view9.tia.application.dagger.modules.NetworkModule;
import com.view9.tia.application.networkModels.AppNetwork;
import com.view9.tia.ext.storage.PreferencesManager;


import dagger.Component;
import okhttp3.OkHttpClient;

@AppScope
@Component(modules = {AppModule.class, GsonModule.class, NetworkModule.class})
public interface AppComponent {

    Context context();

    OkHttpClient okHttpClient();

    AppNetwork vepNetwork();


    PreferencesManager preferencesManager();



    Picasso picasso();

}
