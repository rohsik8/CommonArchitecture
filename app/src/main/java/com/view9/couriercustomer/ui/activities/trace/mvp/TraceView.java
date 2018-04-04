package com.view9.couriercustomer.ui.activities.trace.mvp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;

import android.databinding.DataBindingUtil;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.view9.couriercustomer.R;
import com.view9.couriercustomer.databinding.TraceLayoutBinding;
import com.view9.couriercustomer.ui.activities.OrderStatus.OrderListActivity;
import com.view9.couriercustomer.ui.activities.trace.TraceParams;
import com.view9.couriercustomer.utils.Constants;


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


        binding.btnTrace.setOnClickListener(v -> {

            if(binding.etTrack.getText().toString().isEmpty()){
                binding.etTrack.setError("Please Enter Tracking ID");
            }else{
                Intent intent = new Intent(activity, OrderListActivity.class);
                intent.putExtra(Constants.ID,binding.etTrack.getText().toString().trim());
                activity.startActivity(intent);
                binding.etTrack.setText("");
            }

           /* if(HomeActivity.check)
                HomeActivity.check =false;
            RxBus.getInstance().send("orderStatus");*/
        });
    }



}
