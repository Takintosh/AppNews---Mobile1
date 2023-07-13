package com.example.appnews.fragments;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appnews.R;
import com.example.appnews.adapters.NewsDetailsAdapter;
import com.example.appnews.models.News;

public class NewsDetailsFragment extends Fragment {

    private RecyclerView recyclerViewNews;
    private NewsDetailsAdapter newsDetailsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_details, container, false);

        // Obtén el objeto de la noticia seleccionada del argumento
        Bundle args = getArguments();
        if (args != null) {
            News news = args.getParcelable("news");
            if (news != null) {
                recyclerViewNews = view.findViewById(R.id.recyclerViewNews);
                recyclerViewNews.setLayoutManager(new LinearLayoutManager(getActivity()));
                newsDetailsAdapter = new NewsDetailsAdapter(news);
                recyclerViewNews.setAdapter(newsDetailsAdapter);
            }
        }

        return view;
    }
}

