package com.rumeysaozer.javaretrofitrxjavasingle.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rumeysaozer.javaretrofitrxjavasingle.model.BloodItem;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BloodAPIService {
    private String BASE_URL = "https://random-data-api.com/api/";
    Gson gson = new GsonBuilder().setLenient().create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    final BloodAPI bloodAPI = retrofit.create(BloodAPI.class);
    public Single<List<BloodItem>> getData() {
        return bloodAPI.getData();
    }
}
