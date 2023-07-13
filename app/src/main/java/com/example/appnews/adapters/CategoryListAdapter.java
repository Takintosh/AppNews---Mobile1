package com.example.appnews.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnews.R;
import com.example.appnews.models.Category;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {

    private List<Category> categories;
    private CategoryClickListener categoryClickListener;

    // Constructor que recibe la lista de categorías y el listener de clic en categoría
    public CategoryListAdapter(List<Category> categories, CategoryClickListener categoryClickListener) {
        this.categories = categories;
        this.categoryClickListener = categoryClickListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el diseño del elemento de la lista de categorías
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        // Obtiene la categoría en la posición actual
        Category category = categories.get(position);
        // Vincula los datos de la categoría al ViewHolder
        holder.bind(category);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    // ViewHolder para mostrar cada elemento de la lista de categorías
    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewCategory;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            // Obtiene las referencias de los elementos de la vista del elemento de la lista
            textViewCategory = itemView.findViewById(R.id.textViewCategory);
        }

        public void bind(final Category category) {
            // Establece el nombre de la categoría en el TextView
            textViewCategory.setText(category.getCategoryName());

            // Establece el clic en el elemento de la lista
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Notifica al listener de clic en categoría que se ha hecho clic en una categoría
                    categoryClickListener.onCategoryClick(category);
                }
            });
        }
    }

    // Interfaz para el listener de clic en categoría
    public interface CategoryClickListener {
        void onCategoryClick(Category category);
    }
}
