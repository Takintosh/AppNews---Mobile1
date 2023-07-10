package com.example.appnews.models;

import java.io.Serializable;

public class Category implements Serializable {

    private int id;
    private String category_name;

    public Category() {
        this.id = 0;
        this.category_name = "";
    }

    public Category(String category_name) {
        this.id = 0;
        this.category_name = category_name;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategoryName() {
        return category_name;
    }
    public void setCategoryName(String category_name) {
        this.category_name = category_name;
    }

}
