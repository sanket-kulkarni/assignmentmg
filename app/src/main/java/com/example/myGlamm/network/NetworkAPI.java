package com.example.myGlamm.network;

import com.example.myGlamm.model.search.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Sanket on 14.12.2018.
 */

public interface NetworkAPI {
    @GET("/api/v2.1/search")
    Call<Response> getData(@Header("user-key") String apiKey,
                           @Query("start") String start,
                           @Query("count") String count,
                           @Query("lat") String lat,
                           @Query("lon") String lon
    );
}
