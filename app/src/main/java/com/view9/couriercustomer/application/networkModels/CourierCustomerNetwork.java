package com.view9.couriercustomer.application.networkModels;



import com.view9.couriercustomer.ui.activities.OrderStatus.OrderParams;
import com.view9.couriercustomer.ui.activities.OrderStatus.orderResponse.OrderResponse;
import com.view9.couriercustomer.ui.activities.trace.TraceParams;

import com.view9.couriercustomer.utils.Constants;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;


public interface CourierCustomerNetwork {

    @POST
    Observable<OrderResponse> getTrackingObservable(@Url String url, @Body OrderParams orderParams);

    /*@POST(Constants.LOGOUT)
    Observable<LogoutResponse> postlogoutObservable(@Body LogoutParams logoutParams);
*/

}
