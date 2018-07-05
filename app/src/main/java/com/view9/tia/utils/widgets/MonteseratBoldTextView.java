package com.view9.tia.utils.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.view9.tia.application.dagger.AppApplication;


public class MonteseratBoldTextView extends android.support.v7.widget.AppCompatTextView {
    public MonteseratBoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomTextStyle();

    }

    public MonteseratBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomTextStyle();
    }

    public MonteseratBoldTextView(Context context) {
        super(context);
        setCustomTextStyle();
    }

    private void setCustomTextStyle() {
        this.setTypeface(AppApplication.Fonts.MONTESERATBOLD);
    }


}