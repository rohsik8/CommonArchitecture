package com.view9.couriercustomer.application.dagger;

import android.app.Activity;
import android.app.Application;
import android.graphics.Typeface;
import android.support.v4.BuildConfig;


import com.view9.couriercustomer.application.dagger.modules.AppModule;
import com.view9.couriercustomer.utils.Constants;

import timber.log.Timber;

/**
 * Created by dell on 8/7/2017.
 */

public class CourierCustomerApplication extends Application{

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



    public static CourierCustomerApplication get(Activity activity) {
        return (CourierCustomerApplication) activity.getApplication();
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
