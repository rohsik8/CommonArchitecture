package com.view9.tia.utils.widgets;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.view9.tia.application.dagger.AppApplication;


public class MonteseratRegularEditText extends AppCompatEditText {
    public MonteseratRegularEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomTextStyle();

    }

    public MonteseratRegularEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomTextStyle();
    }

    public MonteseratRegularEditText(Context context) {
        super(context);
        setCustomTextStyle();
    }

    private void setCustomTextStyle() {
        this.setTypeface(AppApplication.Fonts.MONTESERATREGULAR);
    }


}