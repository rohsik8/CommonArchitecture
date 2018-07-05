package com.view9.tia.utils.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.view9.tia.application.dagger.AppApplication;


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
        this.setTypeface(AppApplication.Fonts.MONTESERATREGULAR);
    }


}