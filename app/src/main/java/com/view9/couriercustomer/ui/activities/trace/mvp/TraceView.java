package com.view9.couriercustomer.ui.activities.trace.mvp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;

import android.databinding.DataBindingUtil;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.view9.couriercustomer.R;
import com.view9.couriercustomer.databinding.TraceLayoutBinding;
import com.view9.couriercustomer.ui.activities.trace.TraceParams;


import io.reactivex.Observable;


@SuppressLint("ViewConstructor")
public class TraceView extends FrameLayout {
    ProgressDialog progressDialog;

    final int pBarMax = 100;
    public Activity activity;
    public SharedPreferences sharedPreferencesN;
    int progress = 0;
    TraceLayoutBinding binding;

    public TraceView(@NonNull Activity activity) {
        super(activity);
        this.activity = activity;
        sharedPreferencesN = PreferenceManager.getDefaultSharedPreferences(activity);
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Signing in...");
        binding = DataBindingUtil.setContentView(activity, R.layout.trace_layout);
    }


    public Observable<CharSequence> mobileCharSequenceObservable() {
        return RxTextView.textChanges(binding.etTrack);
    }



    public Observable<Object> loginButtonObservable() {
        return RxView.clicks(binding.btnTrace);
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


    /*public void showMobileError() {
        enableError(binding.mobileView);
        binding.mobileView.setError("Invalid username.");
    }

    public void hideMobileError() {
        disableError(binding.mobileView);
        binding.mobileView.setError(null);
    }
*/


    public void enableButton(Boolean enabled) {
        binding.btnTrace.setEnabled(enabled);
    }

    public void showProgressDialog(Boolean show) {
        if (show) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    public TraceParams traceParams() {
        return TraceParams.builder()
                .trace(binding.etTrack.getText().toString().trim())
                .build();
    }
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
