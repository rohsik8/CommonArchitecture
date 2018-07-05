package com.view9.tia.application.dagger.modules;


import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.view9.tia.application.dagger.AppScope;
import com.view9.tia.utils.AppTypeAdapterFactory;


import dagger.Module;
import dagger.Provides;

@Module
public class GsonModule {

    @Provides
    @AppScope
    public Gson gson()
    {
        return Converters.registerAll(new GsonBuilder())
                .registerTypeAdapterFactory(AppTypeAdapterFactory.create())
                .create();
    }
}
