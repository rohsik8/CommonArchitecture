
package com.view9.couriercustomer.ui.activities.login.loginResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FieldMobile {

    @SerializedName("und")
    @Expose
    private List<Und> und = null;

    public List<Und> getUnd() {
        return und;
    }

    public void setUnd(List<Und> und) {
        this.und = und;
    }

}
