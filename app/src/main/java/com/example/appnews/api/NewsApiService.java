package com.example.appnews.api;

import com.example.appnews.models.News;
import com.example.appnews.models.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NewsApiService {
    //String API_KEY = "cb698ff3d2584e8288367228f998a554";
    @Headers("X-Api-Key: cb698ff3d2584e8288367228f998a554")
    @GET("top-headlines")
    Call<NewsResponse> getTopHeadlines(
            @Query("country") String country
    );
}