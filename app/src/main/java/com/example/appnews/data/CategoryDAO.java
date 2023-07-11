package com.example.appnews.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appnews.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private SQLiteDatabase db;

    public CategoryDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public long insertCategory(Category category) {
        ContentValues values = new ContentValues();
        values.put("category_name", category.getCategoryName());
        values.put("category_tag", category.getCategoryTag());
        return db.insert("categories", null, values);
    }

    public Category getCategory(int categoryId) {
        String[] projection = {"id", "category_name", "category_tag"};
        String selection = "id = ?";
        String[] selectionArgs = {String.valueOf(categoryId)};

        Cursor cursor = db.query("categories", projection, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            Category category = new Category();
            category.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            category.setCategoryName(cursor.getString(cursor.getColumnIndexOrThrow("category_name")));
            category.setCategoryTag(cursor.getString(cursor.getColumnIndexOrThrow("category_tag")));
            cursor.close();
            return category;
        } else {
            cursor.close();
            return null;
        }
    }

    public List<Category> listCategories() {
        List<Category> listCategories = new ArrayList<>();
        String[] projection = {"id", "category_name", "category_tag"};

        Cursor cursor = db.query("categories", projection, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Category category = new Category();
            category.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            category.setCategoryName(cursor.getString(cursor.getColumnIndexOrThrow("category_name")));
            category.setCategoryTag(cursor.getString(cursor.getColumnIndexOrThrow("category_tag")));

            listCategories.add(category);
        }
        return listCategories;
    }

}
