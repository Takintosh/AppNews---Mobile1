package com.example.appnews.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnews.R;
import com.example.appnews.adapters.NewsListAdapter;
import com.example.appnews.api.ApiClient;
import com.example.appnews.api.NewsApiService;
import com.example.appnews.models.News;
import com.example.appnews.models.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListFragment extends Fragment {

    private RecyclerView recyclerViewNews;
    private NewsListAdapter newsListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        // Obtén la instancia de la API y realiza la llamada
        NewsApiService apiService = ApiClient.getClient().create(NewsApiService.class);
        Call<NewsResponse> call = apiService.getTopHeadlines("US");

        // Configura el RecyclerView
        recyclerViewNews = view.findViewById(R.id.recyclerViewNews);
        recyclerViewNews.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsListAdapter = new NewsListAdapter();
        recyclerViewNews.setAdapter(newsListAdapter);

        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()) {
                    NewsResponse newsResponse = response.body();
                    List<News> newsList = newsResponse.getArticles();
                    Log.d("NewsListFragment", "onResponse: " + response.body().toString());
                    if (newsList != null) {
                        newsListAdapter.setNewsList(newsList);
                    }
                } else {
                    // La respuesta no fue exitosa, maneja el error según tus necesidades
                    Log.d("NewsListFragment", "onResponse: " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                // Ocurrió un error en la llamada a la API, maneja el error según tus necesidades
                Log.d("NewsListFragment", "onFailure: " + t.getLocalizedMessage());
            }
        });

        return view;


    }
}
