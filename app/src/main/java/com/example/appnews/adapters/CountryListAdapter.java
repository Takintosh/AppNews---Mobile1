package com.example.appnews.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnews.R;
import com.example.appnews.models.Country;

import java.util.List;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryViewHolder> {

    private List<Country> countries;

    // Constructor que recibe la lista de países
    public CountryListAdapter(List<Country> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el diseño del elemento de la lista de países
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CountryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        // Obtiene el país en la posición actual
        Country country = countries.get(position);
        // Vincula los datos del país al ViewHolder
        holder.bind(country);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    // ViewHolder para mostrar cada elemento de la lista de países
    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewCategory;

        public CountryViewHolder(View itemView) {
            super(itemView);
            // Obtiene las referencias de los elementos de la vista del elemento de la lista
            textViewCategory = itemView.findViewById(R.id.textViewCategory);
        }

        public void bind(final Country country) {
            // Establece el nombre del país en el TextView
            textViewCategory.setText(country.getCountryName());
            // Establece el país como etiqueta del elemento de la lista
            itemView.setTag(country);
        }
    }
}
