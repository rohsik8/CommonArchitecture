package com.view9.couriercustomer.ui.activities.login.dagger;


import android.app.Activity;


import com.view9.couriercustomer.application.networkModels.CourierCustomerNetwork;
import com.view9.couriercustomer.ext.storage.PreferencesManager;
import com.view9.couriercustomer.ui.activities.login.mvp.LoginModel;
import com.view9.couriercustomer.ui.activities.login.mvp.LoginPresenter;
import com.view9.couriercustomer.ui.activities.login.mvp.LoginView;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private final Activity activity;

    public LoginModule(Activity activity) {
        this.activity = activity;
    }

    @LoginScope
    @Provides
    LoginView loginView() {
        return new LoginView(activity);
    }


    @LoginScope
    @Provides
    LoginModel loginModel(PreferencesManager preferencesManager, CourierCustomerNetwork courierNetwork) {
        return new LoginModel(activity, preferencesManager, courierNetwork);
    }

    @LoginScope
    @Provides
    LoginPresenter loginPresenter(LoginView loginView, LoginModel loginModel, PreferencesManager preferencesManager) {
        return new LoginPresenter(loginView, loginModel, preferencesManager);
    }

}
