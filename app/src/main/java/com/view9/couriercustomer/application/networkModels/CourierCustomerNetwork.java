package com.view9.couriercustomer.application.networkModels;



import com.view9.couriercustomer.ui.activities.trace.TraceParams;
import com.view9.couriercustomer.ui.activities.trace.TraceResponse.LoginResponse;
import com.view9.couriercustomer.utils.Constants;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface CourierCustomerNetwork {


    @POST(Constants.LOGIN)
    Observable<LoginResponse> postLoginObservable(@Body TraceParams traceParams);

    /*@POST(Constants.LOGOUT)
    Observable<LogoutResponse> postlogoutObservable(@Body LogoutParams logoutParams);
*/

}
