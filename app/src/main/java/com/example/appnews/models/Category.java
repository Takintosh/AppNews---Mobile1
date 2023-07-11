package com.example.appnews.models;

import java.io.Serializable;

public class Category implements Serializable {

    private int id;
    private String category_name;
    private String category_tag;

    public Category() {
        this.id = 0;
        this.category_name = "";
        this.category_tag = "";
    }

    public Category(String category_name, String category_tag) {
        this.id = 0;
        this.category_name = category_name;
        this.category_tag = category_tag;
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
    public String getCategoryTag() {
        return category_tag;
    }
    public void setCategoryTag(String category_tag) {
        this.category_tag = category_tag;
    }

}
