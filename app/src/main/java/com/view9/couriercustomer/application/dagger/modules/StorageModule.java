package com.view9.couriercustomer.application.dagger.modules;


import android.content.Context;

/**/
import com.view9.couriercustomer.application.dagger.AppScope;
import com.view9.couriercustomer.ext.storage.PreferencesManager;

import dagger.Module;
import dagger.Provides;

@Module
public class StorageModule {

    @AppScope
    @Provides
    public PreferencesManager preferencesManager(Context context)
    {
        return new PreferencesManager(context);
    }
}
