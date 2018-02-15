package com.view9.couriercustomer.application.networkModels;

import okhttp3.OkHttpClient;

public class RestServiceGenerator {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


    public RestServiceGenerator() {


    }

//    private static Retrofit.Builder builder = new Retrofit.Builder()
//            .baseUrl(Constants.PAYDOCK_URL)
//            .addConverterFactory(GsonConverterFactory.create())     //toget json response
//            .addConverterFactory(ScalarsConverterFactory.create()) ;  //toget string response
////            .addConverterFactory(SimpleXmlConverterFactory.create()); //toget xml response


//    public static <S> S createService(Class<S> serviceClass) {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        Retrofit retrofit = builder
//                .client(httpClient
//                        .addInterceptor(interceptor)
//                        .connectTimeout(ApiConfig.CONNECT_TIMEOUT, TimeUnit.SECONDS)
//                        .readTimeout(ApiConfig.READ_TIMEOUT, TimeUnit.SECONDS)
//                        .build())
//
//                .build();
//        return retrofit.create(serviceClass);
//    }



    public static OkHttpClient.Builder getHttpClient() {
        return httpClient;
    }
}
