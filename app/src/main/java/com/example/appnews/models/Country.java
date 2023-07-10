package com.example.appnews.models;

import java.io.Serializable;

public class Country implements Serializable {

    private int id;
    private String country_name;

    public Country() {
        this.id = 0;
        this.country_name = "";
    }

    public Country(String country_name) {
        this.id = 0;
        this.country_name = country_name;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCountryName() {
        return country_name;
    }
    public void setCountryName(String country_name) {
        this.country_name = country_name;
    }

}
