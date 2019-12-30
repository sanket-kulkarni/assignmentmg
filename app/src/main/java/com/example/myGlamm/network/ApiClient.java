package com.example.myGlamm.network;


import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sanket on 19-11-2018.
 */

public class ApiClient {

    public static Retrofit retrofit = null;
    public static OkHttpClient getHttpClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //TODO : remove logging interceptors as it is to be used for development purpose
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(300, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS).
                        addInterceptor(logging).
                        build();

        return client;
    }
    public static Retrofit getClient(String BASE_URL) {
       // if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getHttpClient())
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                    .build();
        }
        return retrofit;
    }
//
//    public static Retrofit getClient1() {
//      //  if (retrofit == null)
//        {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(Constants.BASE_URL1)
//                    .client(getHttpClient())
//                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
//                    .build();
//        }
//        return retrofit;
//    }

}
