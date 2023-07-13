package com.example.appnews.api;

import com.example.appnews.models.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NewsApiService {
    String API_KEY = "cb698ff3d2584e8288367228f998a554";

    // Obtiene las principales noticias según el país
    @Headers("X-Api-Key:" + API_KEY)
    @GET("top-headlines")
    Call<NewsResponse> getTopHeadlines(
            @Query("country") String country
    );

    // Obtiene las principales noticias de una categoría específica según el país
    @Headers("X-Api-Key:" + API_KEY)
    @GET("top-headlines")
    Call<NewsResponse> getTopHeadlinesByCategory(
            @Query("country") String country,
            @Query("category") String category
    );

}
