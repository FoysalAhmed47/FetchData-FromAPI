package com.example.techtrix;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OurRetrofit
{
    @GET("photos")

        Call<List<OurDataSet>> getDataSet();
}
