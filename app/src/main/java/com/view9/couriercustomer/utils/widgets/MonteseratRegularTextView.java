package com.view9.couriercustomer.utils.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.view9.couriercustomer.application.dagger.CourierCustomerApplication;


public class MonteseratRegularTextView extends android.support.v7.widget.AppCompatTextView {
    public MonteseratRegularTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomTextStyle();

    }

    public MonteseratRegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomTextStyle();
    }

    public MonteseratRegularTextView(Context context) {
        super(context);
        setCustomTextStyle();
    }

    private void setCustomTextStyle() {
        this.setTypeface(CourierCustomerApplication.Fonts.MONTESERATREGULAR);
    }


}