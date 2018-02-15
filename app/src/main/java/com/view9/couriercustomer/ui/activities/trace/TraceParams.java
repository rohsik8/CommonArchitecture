package com.view9.couriercustomer.ui.activities.trace;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;


@AutoValue
public abstract class TraceParams {

    public static Builder builder() {
        return new $AutoValue_TraceParams.Builder();
    }

    public static TypeAdapter<TraceParams> typeAdapter(Gson gson) {
        return new AutoValue_TraceParams.GsonTypeAdapter(gson);
    }

    @SerializedName("trace")
    public abstract String trace();




    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder trace(String trace);


        public abstract TraceParams build();
    }
}