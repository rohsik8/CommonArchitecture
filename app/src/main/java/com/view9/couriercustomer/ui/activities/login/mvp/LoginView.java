package com.view9.couriercustomer.ui.activities.login.mvp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;

import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.view9.couriercustomer.R;


import io.reactivex.Observable;


@SuppressLint("ViewConstructor")
public class LoginView extends FrameLayout {
    ProgressDialog progressDialog;

    final int pBarMax = 100;
    public Activity activity;
    public SharedPreferences sharedPreferencesN;
    int progress = 0;
    LoginBinding binding;

    public LoginView(@NonNull Activity activity) {
        super(activity);
        this.activity = activity;
        sharedPreferencesN = PreferenceManager.getDefaultSharedPreferences(activity);
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Signing in...");
        binding = DataBindingUtil.setContentView(activity, R.layout.login);
    }


    public Observable<CharSequence> mobileCharSequenceObservable() {
        return RxTextView.textChanges(binding.mobile);
    }

    public Observable<CharSequence> passwordCharSequenceObservable() {
        return RxTextView.textChanges(binding.password);
    }


    public Observable<Object> loginButtonObservable() {
        return RxView.clicks(binding.loginButton);
    }




    // region Helper Methods
    public void enableError(TextInputLayout textInputLayout) {
        if (textInputLayout.getChildCount() == 2)
            textInputLayout.getChildAt(1).setVisibility(View.VISIBLE);
    }

    public void disableError(TextInputLayout textInputLayout) {
        if (textInputLayout.getChildCount() == 2)
            textInputLayout.getChildAt(1).setVisibility(View.GONE);
    }

    public void showPasswordError() {
        enableError(binding.passwordView);
        binding.passwordView.setError("Invalid password.");
    }

    public void hidePasswordError() {
        disableError(binding.passwordView);
        binding.passwordView.setError(null);
    }

    public void showMobileError() {
        enableError(binding.mobileView);
        binding.mobileView.setError("Invalid username.");
    }

    public void hideMobileError() {
        disableError(binding.mobileView);
        binding.mobileView.setError(null);
    }



    public void enableButton(Boolean enabled) {
        binding.loginButton.setEnabled(enabled);
    }

    public void showProgressDialog(Boolean show) {
        if (show) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    public LoginParams loginParams() {
        return LoginParams.builder()
                .username(binding.mobile.getText().toString().trim())
                .password(binding.password.getText().toString().trim())
                .build();
    }
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
