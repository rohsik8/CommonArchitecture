package com.view9.couriercustomer.ui.activities.login;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;


@AutoValue
public abstract class LoginParams {

    public static Builder builder() {
        return new $AutoValue_LoginParams.Builder();
    }

    public static TypeAdapter<LoginParams> typeAdapter(Gson gson) {
        return new AutoValue_LoginParams.GsonTypeAdapter(gson);
    }

    @SerializedName("username")
    public abstract String username();

    @SerializedName("password")
    public abstract String password();


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder username(String username);

        public abstract Builder password(String password);

        public abstract LoginParams build();
    }
}