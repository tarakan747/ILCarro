package com.example.ilcarroappl;

import com.example.ilcarroappl.data.provider.web.Api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {
    private static final ApiProvider instance = new ApiProvider();
    private Api api;


    public static ApiProvider getInstance() {
        return instance;
    }

    private ApiProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://java-3-ilcarro-team-b.herokuapp.com/")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = retrofit.create(Api.class);
    }

    public Api getApi() {
        return api;
    }


}
