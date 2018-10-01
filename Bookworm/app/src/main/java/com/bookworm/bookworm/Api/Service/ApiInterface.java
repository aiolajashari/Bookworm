package com.bookworm.bookworm.Api.Service;

import com.bookworm.bookworm.Api.Model.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Valdrin on 2/7/2018.
 */

public interface ApiInterface {

    @GET("/search.json")
    Call<Example> getLibrary(@Query("title") String title);
}
