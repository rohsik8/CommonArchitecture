package com.view9.couriercustomer.ui.activities.OrderStatus;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;


@AutoValue
public abstract class OrderParams {

    public static Builder builder() {
        return new $AutoValue_OrderParams.Builder();
    }

    public static TypeAdapter<OrderParams> typeAdapter(Gson gson) {
        return new AutoValue_OrderParams.GsonTypeAdapter(gson);
    }

    @SerializedName("branchCode")
    public abstract String branchCode();

    @SerializedName("billNo")
    public abstract String billNo();


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder branchCode(String branchCode);

        public abstract Builder billNo(String billNo);

        public abstract OrderParams build();
    }
}