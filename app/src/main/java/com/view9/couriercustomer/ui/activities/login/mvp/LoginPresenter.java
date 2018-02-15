package com.view9.couriercustomer.ui.activities.login.mvp;


import android.text.TextUtils;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.view9.couriercustomer.ext.storage.PreferencesManager;
import com.view9.couriercustomer.ui.activities.login.loginResponse.LoginResponse;
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

public class LoginPresenter {

    private final LoginView loginView;
    private final LoginModel loginModel;
    DisposableObserver<Boolean> loginObserver;
    PreferencesManager preferencesManager;


    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public LoginPresenter(LoginView loginView, LoginModel loginModel, PreferencesManager preferencesManager) {
        this.loginView = loginView;
        this.loginModel = loginModel;
        this.preferencesManager = preferencesManager;

    }


    public void onCreate() {
        formValidation();
        loginButtonObservable();

    }


    private boolean validatePassword(String password) {
        return password.length() > 3;
    }


    private void formValidation() {


        loginView.mobileCharSequenceObservable()
                .doOnNext(charSequence -> loginView.hideMobileError())
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
                            loginView.showMobileError();
                        } else {
                            loginView.hideMobileError();
                        }
                    }
                });


        loginView.passwordCharSequenceObservable()
                .doOnNext(charSequence -> loginView.hidePasswordError())
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
                            loginView.showPasswordError();
                        } else {
                            loginView.hidePasswordError();
                        }
                    }
                });


        Observable.combineLatest(
                loginView.passwordCharSequenceObservable(),
                loginView.mobileCharSequenceObservable(),

                (password, mobile) -> {

                    boolean isPasswordValid = validatePassword(password.toString());
                    boolean isMobileValid = validatePassword(mobile.toString());

                    return isPasswordValid && isMobileValid;

                }).observeOn(AndroidSchedulers.mainThread()) // UI Thread
                .subscribe(new Observer<Boolean>() {

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
                    public void onNext(Boolean validFields) {
                        loginView.enableButton(validFields);
                    }
                });

    }


    private void loginButtonObservable() {

        DisposableObserver<LoginResponse> disposableObserver = new DisposableObserver<LoginResponse>() {

            @Override
            public void onNext(LoginResponse loginResponse) {
                loginModel.saveData(Constants.COOKIE, loginResponse.getData().getSessionName() + "=" + loginResponse.getData().getSessid());
                loginModel.saveData(Constants.TOKEN, loginResponse.getData().getToken());
                loginModel.saveData(Constants.USERID, loginResponse.getData().getUser().getUid());
                loginModel.saveData(Constants.FIRSTNAME, loginResponse.getData().getUser().getName());
                loginModel.saveData(Constants.EMAIL, loginResponse.getData().getUser().getMail());
                loginView.startHome();
            }

            @Override
            public void onError(Throwable e) {
                if (e instanceof HttpException) {
                    ResponseBody responseBody = ((HttpException) e).response().errorBody();
                    loginView.showMessage(GeneralUtils.getErrorMessage(responseBody));

                    //loginModel.startDashboard();
                } else if (e instanceof SocketTimeoutException) {
                    loginView.showMessage("Time Out");

                } else if (e instanceof IOException) {
                    loginView.showMessage("Please check your network connection");
                    // loginModel.startDashboard();

                } else {
                    //todo changes
                    loginView.showMessage(e.getMessage());
                    // loginModel.startDashboard();

                }
                loginButtonObservable();
                loginView.startHomeDelivery();

            }

            @Override
            public void onComplete() {

            }
        };


        loginView.loginButtonObservable()
                .doOnNext(__ -> loginView.showProgressDialog(true))
                .map(__ -> loginView.loginParams())
                .observeOn(Schedulers.io())
                .switchMap(loginModel::loginObservable)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> loginView.showProgressDialog(false))
                .subscribe(disposableObserver);

    }


    public void onDestroy() {
        compositeDisposable.clear();
    }


}
