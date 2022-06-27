package com.rumeysaozer.javaretrofitrxjavasingle.service;

import com.rumeysaozer.javaretrofitrxjavasingle.model.BloodItem;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface BloodAPI {
    @GET("blood/random_blood?size=20")
    Single<List<BloodItem>> getData();
}
