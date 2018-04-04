
package com.view9.couriercustomer.ui.activities.OrderStatus.orderResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable
{

    @SerializedName("result_query")
    @Expose
    private List<ResultQuery> resultQuery = null;
    @SerializedName("result_booking")
    @Expose
    private List<ResultBooking> resultBooking = null;
    private final static long serialVersionUID = 4791075304716395866L;

    public List<ResultQuery> getResultQuery() {
        return resultQuery;
    }

    public void setResultQuery(List<ResultQuery> resultQuery) {
        this.resultQuery = resultQuery;
    }

    public List<ResultBooking> getResultBooking() {
        return resultBooking;
    }

    public void setResultBooking(List<ResultBooking> resultBooking) {
        this.resultBooking = resultBooking;
    }

}
