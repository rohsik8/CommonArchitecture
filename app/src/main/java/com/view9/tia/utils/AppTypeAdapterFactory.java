package com.view9.tia.utils;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;


@GsonTypeAdapterFactory
public abstract class AppTypeAdapterFactory implements TypeAdapterFactory {

    public  static TypeAdapterFactory create(){
        return new AutoValueGson_AppTypeAdapterFactory();
    }


}
