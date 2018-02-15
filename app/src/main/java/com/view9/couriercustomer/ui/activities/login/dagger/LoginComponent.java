package com.view9.couriercustomer.ui.activities.login.dagger;




import com.view9.couriercustomer.application.dagger.AppComponent;
import com.view9.couriercustomer.ui.activities.login.LoginActivity;

import dagger.Component;

@LoginScope
@Component(modules = LoginModule.class, dependencies = AppComponent.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);
}
