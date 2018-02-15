package com.view9.couriercustomer.ui.activities.splash.dagger;




import com.view9.couriercustomer.application.dagger.AppComponent;
import com.view9.couriercustomer.ui.activities.splash.SplashActivity;

import dagger.Component;

@SplashScope
@Component(modules = SplashModule.class, dependencies = AppComponent.class)
public interface SplashComponent {

    void inject(SplashActivity splashActivity);
}
