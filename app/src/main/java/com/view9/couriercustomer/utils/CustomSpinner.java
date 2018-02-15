/*
package com.view9.couriercustomer.utils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.view9.couriercustomer.R;


*/
/**
 * Created by dell on 2/6/2018.
 *//*


public class CustomSpinner extends BaseAdapter {

    Activity context;
    String[] countryNames;
    LayoutInflater inflter;

    public CustomSpinner(Activity applicationContext, String[] countryNames) {
        this.context = applicationContext;
        this.countryNames = countryNames;
        inflter = (LayoutInflater.from(applicationContext));
    }


    @Override
    public View getView(int i, View view, ViewGroup viccewGroup) {
        view = inflter.inflate(R.layout.custom_spinner_items, null);
        TextView names = (TextView) view.findViewById(R.id.textView);
        names.setText(countryNames[i]);
        return view;
    }

    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}*/
