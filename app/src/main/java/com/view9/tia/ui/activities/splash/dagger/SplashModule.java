package com.view9.tia.ui.activities.splash.dagger;


import android.app.Activity;


import com.view9.tia.ext.storage.PreferencesManager;
import com.view9.tia.ui.activities.splash.mvp.SplashModel;
import com.view9.tia.ui.activities.splash.mvp.SplashPresenter;
import com.view9.tia.ui.activities.splash.mvp.SplashView;


import dagger.Module;
import dagger.Provides;

@Module
public class SplashModule {

    private final Activity activity;

    public SplashModule(Activity activity) {
        this.activity = activity;
    }

    @SplashScope
    @Provides
    public SplashView splashView()
    {
        return new SplashView(activity);
    }


    @SplashScope
    @Provides
    public SplashModel splashModel(PreferencesManager preferencesManager)
    {
        return new SplashModel(activity,preferencesManager);
    }

    @SplashScope
    @Provides
    public SplashPresenter splashPresenter(SplashView splashView, SplashModel splashModel, PreferencesManager preferencesManager)
    {
        return new SplashPresenter(splashView,splashModel, preferencesManager);
    }
}
