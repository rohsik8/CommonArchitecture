package com.view9.tia.application.dagger.modules;


import android.app.Application;
import android.content.Context;


import com.view9.tia.application.dagger.AppScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Context context;

    public AppModule(Application application) {
        this.context = application.getApplicationContext();
    }


    @Provides
    @AppScope
    public Context context()
    {
        return context;
    }
}
