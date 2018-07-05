package com.view9.tia.application.dagger.modules;


import android.content.Context;

/**/
import com.view9.tia.application.dagger.AppScope;
import com.view9.tia.ext.storage.PreferencesManager;

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
