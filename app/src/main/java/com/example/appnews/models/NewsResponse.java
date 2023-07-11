package com.example.appnews.models;

import java.util.List;

public class NewsResponse {
    private String status;
    private int totalResults;
    private List<News> articles;

    public List<News> getArticles() {
        return articles;
    }
}
