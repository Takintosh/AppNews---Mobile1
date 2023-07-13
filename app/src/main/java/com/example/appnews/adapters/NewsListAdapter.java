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

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>{

    private List<News> newsList;
    private OnItemClickListener onItemClickListener;

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el diseño de la vista del elemento de la lista
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        // Obtener la noticia en la posición actual
        News news = newsList.get(position);
        // Vincular los datos de la noticia a la vista del elemento de la lista
        holder.bind(news);
    }

    @Override
    public int getItemCount() {
        return newsList != null ? newsList.size() : 0;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private ImageView imageView;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            // Inicializar las vistas del elemento de la lista
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            imageView = itemView.findViewById(R.id.imageViewNews);

            // Establecer el oyente de clics en la vista del elemento de la lista
            itemView.setOnClickListener(this);
        }

        public void bind(News news) {
            // Asignar los datos de la noticia a las vistas correspondientes
            textViewTitle.setText(news.getTitle());
            textViewDescription.setText(news.getDescription());
            Picasso.get()
                    .load(news.getUrlToImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(imageView);
        }

        @Override
        public void onClick(View v) {
            // Obtener la posición del elemento de la lista en el que se hizo clic
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && onItemClickListener != null) {
                // Obtener la noticia en la posición clicada
                News news = newsList.get(position);
                // Notificar al listener que se hizo clic en la noticia
                onItemClickListener.onItemClick(news);
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(News news);
    }
}
