package com.view9.couriercustomer.ui.activities.OrderStatus.dagger;





import com.view9.couriercustomer.application.dagger.AppComponent;
import com.view9.couriercustomer.ui.activities.OrderStatus.OrderListActivity;

import dagger.Component;

@OrderScope
@Component(modules = OrderModule.class, dependencies = AppComponent.class)
public interface OrderComponent {

    void inject(OrderListActivity orderListActivity);
}
