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

    public CategoryListAdapter(List<Category> categories, CategoryClickListener categoryClickListener) {
        this.categories = categories;
        this.categoryClickListener = categoryClickListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.bind(category);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewCategory;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            textViewCategory = itemView.findViewById(R.id.textViewCategory);
        }

        public void bind(final Category category) {
            textViewCategory.setText(category.getCategoryName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    categoryClickListener.onCategoryClick(category);
                }
            });
        }
    }

    public interface CategoryClickListener {
        void onCategoryClick(Category category);
    }

}
