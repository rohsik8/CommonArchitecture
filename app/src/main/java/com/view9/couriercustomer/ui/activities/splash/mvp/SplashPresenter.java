package com.view9.couriercustomer.ui.activities.splash.mvp;




import com.view9.couriercustomer.ext.storage.PreferencesManager;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class SplashPresenter {

    private final SplashView splashView;
    private final SplashModel splashModel;
    DisposableObserver<Boolean> loginObserver;
    PreferencesManager preferencesManager;


    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public SplashPresenter(SplashView splashView, SplashModel splashModel, PreferencesManager preferencesManager) {
        this.splashView = splashView;
        this.splashModel = splashModel;
        this.preferencesManager = preferencesManager;

    }

    public void onResume() {
        loginObserver = loginObserver();
        start3SecondSleep();
    }

    public void onDestroy() {
        compositeDisposable.clear();
    }


    private DisposableObserver<Boolean> loginObserver() {
        return new DisposableObserver<Boolean>() {
            @Override
            public void onNext(Boolean aBoolean) {

                    splashView.startTrace();
            }

            @Override
            public void onError(Throwable e) {
                Timber.e("Error" + e.getMessage());
            }

            @Override
            public void onComplete() {
                Timber.e("Completed");

            }
        };
    }


    private void sleepFor3Seconds() {

        try {

            Thread.sleep(3000);

        } catch (InterruptedException e) {
            Timber.d("Operation was interrupted");
        }


    }

    private Observable<Boolean> getSleepObservable() {
        return Observable.just(true)
                .map(aBoolean -> {
                    sleepFor3Seconds();
                    return aBoolean;
                });
    }

    private void start3SecondSleep() {
        getSleepObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loginObserver);
    }


}
