package com.example.appnews.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.database.sqlite.SQLiteDatabase;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnews.R;
import com.example.appnews.adapters.CategoryListAdapter;
import com.example.appnews.adapters.CountryListAdapter;
import com.example.appnews.data.CategoryDAO;
import com.example.appnews.data.CountryDAO;
import com.example.appnews.database.DatabaseHelper;
import com.example.appnews.models.Category;
import com.example.appnews.models.Country;

import java.util.List;

public class CategoryListFragment extends Fragment {

    private RecyclerView recyclerViewCategories, recyclerViewCountries;
    private CategoryListAdapter categoryListAdapter;
    private CountryListAdapter countryListAdapter;
    private CategoryDAO categoryDAO;
    private CountryDAO countryDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);

        // Configurar recyclerviews
        recyclerViewCategories = view.findViewById(R.id.recyclerViewCategories);
        recyclerViewCategories.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewCountries = view.findViewById(R.id.recyclerViewCountries);
        recyclerViewCountries.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Inicializar DAO
        DatabaseHelper dbHelper = new DatabaseHelper(this.getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        categoryDAO = new CategoryDAO(db);
        countryDAO = new CountryDAO(db);

        // Obtener listas
        List<Category> listCategories = categoryDAO.listCategories();
        List<Country> listCountries = countryDAO.listCountries();

        // Inicializar adaptadores
        categoryListAdapter = new CategoryListAdapter(listCategories);
        countryListAdapter = new CountryListAdapter(listCountries);

        recyclerViewCategories.setAdapter(categoryListAdapter);
        recyclerViewCountries.setAdapter(countryListAdapter);
        
        return view;
    }
}
