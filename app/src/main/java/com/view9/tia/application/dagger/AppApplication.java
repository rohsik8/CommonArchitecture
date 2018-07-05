package com.view9.tia.application.dagger;

import android.app.Activity;
import android.app.Application;
import android.graphics.Typeface;
import android.support.v4.BuildConfig;


import com.view9.tia.application.dagger.modules.AppModule;
import com.view9.tia.utils.Constants;

import timber.log.Timber;


public class AppApplication extends Application{

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initializeFonts();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    super.log(priority, Constants.LOG_TAG, message, t);
                }
            });
        }

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();



    }



    public static AppApplication get(Activity activity) {
        return (AppApplication) activity.getApplication();
    }


    private void initializeFonts() {
        Fonts.MONTESERATREGULAR = Typeface.createFromAsset(getAssets(), "Montserrat-Regular.otf");
        Fonts.MONTESERATBOLD = Typeface.createFromAsset(getAssets(), "Montserrat-Bold.otf");

    }

    public static final class Fonts {
        public static Typeface MONTESERATREGULAR;
        public static Typeface MONTESERATBOLD;

    }
    public AppComponent appComponent() {
        return appComponent;
    }
}
