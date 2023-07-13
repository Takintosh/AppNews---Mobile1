package com.example.appnews.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnews.R;
import com.example.appnews.models.News;
import com.squareup.picasso.Picasso;

public class NewsDetailsAdapter extends RecyclerView.Adapter<NewsDetailsAdapter.NewsDetailsViewHolder> {

    private News news;

    public NewsDetailsAdapter(News news) {
        this.news = news;
    }

    @NonNull
    @Override
    public NewsDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_details_news, parent, false);
        return new NewsDetailsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsDetailsViewHolder holder, int position) {
        holder.bind(news);
    }

    @Override
    public int getItemCount() {
        return 1; // Solo hay una noticia en la lista
    }

    public static class NewsDetailsViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDate;
        private TextView textViewContent;
        private TextView textViewAuthor;
        private ImageView imageViewNews;

        public NewsDetailsViewHolder(View itemView) {
            super(itemView);
            imageViewNews = itemView.findViewById(R.id.imageViewNews);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewPublishedAt);
            textViewContent = itemView.findViewById(R.id.textViewContent);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
        }

        public void bind(final News news) {
            textViewTitle.setText(news.getTitle());
            textViewDate.setText(news.getPublishedAt());
            textViewContent.setText(news.getContent());
            textViewAuthor.setText(news.getAuthor());
            Picasso.get()
                    .load(news.getUrlToImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(imageViewNews);
        }
    }
}
