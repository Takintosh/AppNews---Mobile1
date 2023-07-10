package com.example.appnews.api;

import com.example.appnews.models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiService {
    @GET("top-headlines")
    Call<News> getTopHeadlines(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}