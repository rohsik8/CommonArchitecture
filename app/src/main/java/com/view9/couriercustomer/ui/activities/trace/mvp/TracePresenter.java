package com.view9.couriercustomer.ui.activities.trace.mvp;


import android.text.TextUtils;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.view9.couriercustomer.ext.storage.PreferencesManager;

import com.view9.couriercustomer.utils.Constants;
import com.view9.couriercustomer.utils.GeneralUtils;


import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class TracePresenter {

    private final TraceView traceView;
    private final TraceModel traceModel;
    DisposableObserver<Boolean> loginObserver;
    PreferencesManager preferencesManager;


    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public TracePresenter(TraceView traceView, TraceModel traceModel, PreferencesManager preferencesManager) {
        this.traceView = traceView;
        this.traceModel = traceModel;
        this.preferencesManager = preferencesManager;

    }


    public void onCreate() {



    }




    public void onDestroy() {
        compositeDisposable.clear();
    }


}
