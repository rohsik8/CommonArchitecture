package com.view9.couriercustomer.utils;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;


@GsonTypeAdapterFactory
public abstract class CourierTypeAdapterFactory implements TypeAdapterFactory {

    public  static TypeAdapterFactory create(){
        return new AutoValueGson_CourierTypeAdapterFactory();
    }


}
