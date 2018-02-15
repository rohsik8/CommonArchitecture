package com.view9.couriercustomer.ui.activities.trace.dagger;




import com.view9.couriercustomer.application.dagger.AppComponent;
import com.view9.couriercustomer.ui.activities.trace.TraceActivity;

import dagger.Component;

@TraceScope
@Component(modules = TraceModule.class, dependencies = AppComponent.class)
public interface TraceComponent {

    void inject(TraceActivity traceActivity);
}
