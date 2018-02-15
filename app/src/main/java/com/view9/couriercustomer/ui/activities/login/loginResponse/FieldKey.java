
package com.view9.couriercustomer.ui.activities.login.loginResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FieldKey {

    @SerializedName("und")
    @Expose
    private List<Und_> und = null;

    public List<Und_> getUnd() {
        return und;
    }

    public void setUnd(List<Und_> und) {
        this.und = und;
    }

}
