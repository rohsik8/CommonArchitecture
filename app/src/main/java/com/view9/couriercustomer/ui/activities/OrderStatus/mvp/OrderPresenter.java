package com.view9.couriercustomer.ui.activities.OrderStatus.mvp;


import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.view9.couriercustomer.ui.activities.OrderStatus.orderResponse.OrderResponse;
import com.view9.couriercustomer.ui.activities.OrderStatus.orderResponse.ResultQuery;
import com.view9.couriercustomer.utils.Constants;

import org.json.JSONObject;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import okhttp3.ResponseBody;

public class OrderPresenter {

    private static String newsId = null;
    private final OrderView orderView;
    private final OrderModel orderModel;
    int page = 0;

    ArrayList<ResultQuery> newsList = new ArrayList<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private LinkedHashMap<String, String> hashMap;
    private DisposableObserver<Timed<Long>> disposableObserver;


    public OrderPresenter(OrderView orderView, OrderModel orderModel) {
        this.orderView = orderView;
        this.orderModel = orderModel;

    }

    public void onCreateView() {
        getOrderList();

    }


    private void getOrderList() {
       orderView.showLoading(true);

        DisposableObserver<OrderResponse> disposableObserver = new DisposableObserver<OrderResponse>() {

            @Override
            public void onNext(OrderResponse orderResponse) {
               /* newsView.setManifest(orde);*/

                if (orderResponse.getSuccess() == true) {

                    newsList.addAll(orderResponse.getData().getResultQuery());
                    orderView.setOrderList(newsList,orderResponse);

                } else {

                    orderView.showMessage(orderResponse.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                orderView.showLoading(false);
                if (e instanceof HttpException) {
                    ResponseBody responseBody = ((HttpException) e).response().errorBody();
                    orderView.showMessage(getErrorMessage(responseBody));

                } else if (e instanceof SocketTimeoutException) {
                    //newsView.showMessage("Time Out");

                    getOrderList();
                } else if (e instanceof IOException) {
                    orderView.showMessage("Please check your network connection");

                } else {
                    orderView.showMessage(e.getMessage());
                }
            }

            @Override
            public void onComplete() {

                orderView.showLoading(false);
            }
        };

        orderModel.getOrderObservable(page, orderView.orderParams())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(disposableObserver);
        compositeDisposable.add(disposableObserver);
    }


    public void onDestroyView() {
        compositeDisposable.clear();
    }

    //error message return
    private String getErrorMessage(ResponseBody responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody.string());
            return jsonObject.getString("message");
        } catch (Exception e) {
            return e.getMessage();
        }
    }


}
