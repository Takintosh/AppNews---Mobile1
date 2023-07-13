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

    // Constructor que recibe la noticia
    public NewsDetailsAdapter(News news) {
        this.news = news;
    }

    @NonNull
    @Override
    public NewsDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el diseño del elemento de la lista de detalles de noticias
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_details_news, parent, false);
        return new NewsDetailsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsDetailsViewHolder holder, int position) {
        // Vincula los datos de la noticia al ViewHolder
        holder.bind(news);
    }

    @Override
    public int getItemCount() {
        return 1; // Solo hay una noticia en la lista
    }

    // ViewHolder para mostrar los detalles de la noticia
    public static class NewsDetailsViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDate;
        private TextView textViewContent;
        private TextView textViewAuthor;
        private ImageView imageViewNews;

        public NewsDetailsViewHolder(View itemView) {
            super(itemView);
            // Obtiene las referencias de los elementos de la vista del elemento de la lista de detalles de noticias
            imageViewNews = itemView.findViewById(R.id.imageViewNews);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewPublishedAt);
            textViewContent = itemView.findViewById(R.id.textViewContent);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
        }

        public void bind(final News news) {
            // Establece los valores de los campos de la noticia en los elementos de la vista
            textViewTitle.setText(news.getTitle());
            textViewDate.setText(news.getPublishedAt());
            textViewContent.setText(news.getContent());
            textViewAuthor.setText(news.getAuthor());
            // Carga la imagen de la noticia utilizando Picasso
            Picasso.get()
                    .load(news.getUrlToImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(imageViewNews);
        }
    }
}
