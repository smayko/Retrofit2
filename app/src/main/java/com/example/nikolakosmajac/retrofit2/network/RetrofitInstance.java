package com.example.nikolakosmajac.retrofit2.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nikola.kosmajac on 2/2/2018.
 */

public class RetrofitInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://navjacinth9.000webhostapp.com/json/";


    public static Retrofit getRetrofitInstance() {
        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
