package com.view9.tia.ui.activities.splash;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;


@AutoValue
public abstract class LogoutParams {

    public static Builder builder() {
        return new AutoValue_LogoutParams.Builder();
    }

    public static TypeAdapter<LogoutParams> typeAdapter(Gson gson) {
        return new AutoValue_LogoutParams.GsonTypeAdapter(gson);
    }

    @SerializedName("username")
    public abstract String username();



    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder username(String username);


        public abstract LogoutParams build();
    }
}