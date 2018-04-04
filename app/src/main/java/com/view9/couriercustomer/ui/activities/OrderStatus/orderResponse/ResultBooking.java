
package com.view9.couriercustomer.ui.activities.OrderStatus.orderResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResultBooking implements Serializable
{

    @SerializedName("ORIGIN")
    @Expose
    private String oRIGIN;
    @SerializedName("DESTINATION")
    @Expose
    private String dESTINATION;
    @SerializedName("BOOK_DATE")
    @Expose
    private String bOOKDATE;
    @SerializedName("status")
    @Expose
    private String status;
    private final static long serialVersionUID = 162740918350700110L;

    public String getORIGIN() {
        return oRIGIN;
    }

    public void setORIGIN(String oRIGIN) {
        this.oRIGIN = oRIGIN;
    }

    public String getDESTINATION() {
        return dESTINATION;
    }

    public void setDESTINATION(String dESTINATION) {
        this.dESTINATION = dESTINATION;
    }

    public String getBOOKDATE() {
        return bOOKDATE;
    }

    public void setBOOKDATE(String bOOKDATE) {
        this.bOOKDATE = bOOKDATE;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
