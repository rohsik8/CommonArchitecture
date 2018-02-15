
package com.view9.couriercustomer.ui.activities.login.loginResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Und_ {

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("format")
    @Expose
    private Object format;
    @SerializedName("safe_value")
    @Expose
    private String safeValue;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Object getFormat() {
        return format;
    }

    public void setFormat(Object format) {
        this.format = format;
    }

    public String getSafeValue() {
        return safeValue;
    }

    public void setSafeValue(String safeValue) {
        this.safeValue = safeValue;
    }

}
