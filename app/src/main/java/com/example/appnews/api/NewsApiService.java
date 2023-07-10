package com.example.appnews.api;

import com.example.appnews.models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NewsApiService {
    @Headers("X-Api-Key: cb698ff3d2584e8288367228f998a554")
    @GET("top-headlines")
    Call<News> getTopHeadlines(
            @Query("category") String category,
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}