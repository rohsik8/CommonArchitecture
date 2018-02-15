package com.view9.couriercustomer.ui.activities.trace.mvp;


import android.text.TextUtils;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.view9.couriercustomer.ext.storage.PreferencesManager;
import com.view9.couriercustomer.ui.activities.trace.TraceResponse.LoginResponse;
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
       /* formValidation();
        loginButtonObservable();*/

    }


   /* private boolean validatePassword(String password) {
        return password.length() > 3;
    }


    private void formValidation() {


        traceView.mobileCharSequenceObservable()
                .doOnNext(charSequence -> traceView.hideMobileError())
                .debounce(400, TimeUnit.MILLISECONDS)
                .filter(charSequence -> !TextUtils.isEmpty(charSequence))
                .observeOn(AndroidSchedulers.mainThread()) // UI Thread
                .subscribe(new Observer<CharSequence>() {

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CharSequence charSequence) {
                        boolean ismobileValid = validatePassword(charSequence.toString());
                        if (!ismobileValid) {
                            traceView.showMobileError();
                        } else {
                            traceView.hideMobileError();
                        }
                    }
                });


        traceView.passwordCharSequenceObservable()
                .doOnNext(charSequence -> traceView.hidePasswordError())
                .debounce(400, TimeUnit.MILLISECONDS)
                .filter(charSequence -> !TextUtils.isEmpty(charSequence))
                .observeOn(AndroidSchedulers.mainThread()) // UI Thread
                .subscribe(new Observer<CharSequence>() {

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CharSequence charSequence) {
                        boolean isPasswordValid = validatePassword(charSequence.toString());
                        if (!isPasswordValid) {
                            traceView.showPasswordError();
                        } else {
                            traceView.hidePasswordError();
                        }
                    }
                });




    }


    private void loginButtonObservable() {

        DisposableObserver<LoginResponse> disposableObserver = new DisposableObserver<LoginResponse>() {

            @Override
            public void onNext(LoginResponse loginResponse) {
                traceModel.saveData(Constants.COOKIE, loginResponse.getData().getSessionName() + "=" + loginResponse.getData().getSessid());
                traceModel.saveData(Constants.TOKEN, loginResponse.getData().getToken());
                traceModel.saveData(Constants.USERID, loginResponse.getData().getUser().getUid());
                traceModel.saveData(Constants.FIRSTNAME, loginResponse.getData().getUser().getName());
                traceModel.saveData(Constants.EMAIL, loginResponse.getData().getUser().getMail());
                traceView.startHome();
            }

            @Override
            public void onError(Throwable e) {
                if (e instanceof HttpException) {
                    ResponseBody responseBody = ((HttpException) e).response().errorBody();
                    traceView.showMessage(GeneralUtils.getErrorMessage(responseBody));

                    //traceModel.startDashboard();
                } else if (e instanceof SocketTimeoutException) {
                    traceView.showMessage("Time Out");

                } else if (e instanceof IOException) {
                    traceView.showMessage("Please check your network connection");
                    // traceModel.startDashboard();

                } else {
                    //todo changes
                    traceView.showMessage(e.getMessage());
                    // traceModel.startDashboard();

                }
                loginButtonObservable();
                traceView.startHomeDelivery();

            }

            @Override
            public void onComplete() {

            }
        };


        traceView.loginButtonObservable()
                .doOnNext(__ -> traceView.showProgressDialog(true))
                .map(__ -> traceView.loginParams())
                .observeOn(Schedulers.io())
                .switchMap(traceModel::loginObservable)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> traceView.showProgressDialog(false))
                .subscribe(disposableObserver);

    }
*/

    public void onDestroy() {
        compositeDisposable.clear();
    }


}
