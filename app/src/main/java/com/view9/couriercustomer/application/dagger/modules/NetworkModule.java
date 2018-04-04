package com.view9.couriercustomer.application.dagger.modules;


import android.content.Context;

import com.google.gson.Gson;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.picasso.Picasso;
import com.view9.couriercustomer.application.dagger.AppScope;
import com.view9.couriercustomer.application.networkModels.CourierCustomerNetwork;
import com.view9.couriercustomer.ext.storage.PreferencesManager;
import com.view9.couriercustomer.utils.Constants;


import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module
public class NetworkModule {


    @AppScope
    @Provides
    public Cache cache(Context context) {
        return new Cache(new File(context.getCacheDir(), Constants.HTTP_DIR_CACHE), Constants.CACHE_SIZE);


    }

    @AppScope
    @Provides
    public PreferencesManager preferencesManager(Context context) {
        return new PreferencesManager(context);
    }

    @AppScope
    @Provides
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> Timber.i(message));
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return httpLoggingInterceptor;
    }


    @AppScope
    @Provides
    OkHttpClient provideClient(PreferencesManager prefs, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    request = request.newBuilder()
                            //.addHeader("Cookie", prefs.get(Constants.COOKIE))
                            //.addHeader("X-CSRF-Token", prefs.get(Constants.TOKEN))
                            .addHeader("Content-Type", "application/json")
                            .build();
                    return chain.proceed(request);
                })
//                .addInterceptor(chain -> {
//                    Response originalResponse = chain.proceed(chain.request());
//                    if (!originalResponse.headers("Set-Cookie").isEmpty()) {
//                        String string = originalResponse.header("Set-Cookie");
//                        String[] parts = string.split(";");
//                        String cookie = parts[0];
//                        prefs.save(Constants.COOKIE, cookie);
//                    }
//                    return originalResponse;
//                })
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .cache(cache)
                .build();
    }

    @AppScope
    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder().client(okHttpClient)
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @AppScope
    @Provides
    public CourierCustomerNetwork courierCustomerNetwork(Retrofit retrofit) {
        return retrofit.create(CourierCustomerNetwork.class);
    }

    @AppScope
    @Provides
    public Picasso picasso(Context context, OkHttpClient okHttpClient) {
        return new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
    }


}
