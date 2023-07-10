package com.example.appnews.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnews.R;
import com.example.appnews.adapters.CategoryListAdapter;
import com.example.appnews.data.CategoryDAO;
import com.example.appnews.data.CountryDAO;
import com.example.appnews.database.DatabaseHelper;
import com.example.appnews.models.Category;
import com.example.appnews.models.Country;

import java.util.ArrayList;
import java.util.List;

public class CategoryListFragment extends Fragment {

    private RecyclerView recyclerView;
    private CategoryListAdapter categoryListAdapter;
    private List<String> categories;
    private CategoryDAO categoryDAO;
    private CountryDAO countryDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);

        // Configurar recyclerview
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Inicializar DAO
        DatabaseHelper dbHelper = new DatabaseHelper(this.getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        categoryDAO = new CategoryDAO(db);

        // Obtener lista de categorías y mostrar en RecyclerView
        List<Category> listCategories = categoryDAO.listCategories();
        categoryListAdapter = new CategoryListAdapter(listCategories);
        recyclerView.setAdapter(categoryListAdapter);
        
        return view;
    }
}
