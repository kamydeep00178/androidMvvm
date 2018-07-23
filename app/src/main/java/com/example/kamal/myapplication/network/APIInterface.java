package com.example.kamal.myapplication.network;

import com.example.kamal.myapplication.model.MovieModel;


import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kamal on 8/2/18.
 */
public interface APIInterface
{

    @GET("/api/unknown")
    Call<MovieModel> getdata();
}
