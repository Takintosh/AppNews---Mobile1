package com.example.appnews.utils;

import android.app.Activity;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.appnews.R;

public class ToolbarHelper {

    public static void setupToolbar(Activity activity, Toolbar toolbar) {
        if (activity instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            appCompatActivity.setSupportActionBar(toolbar);

            ActionBar actionBar = appCompatActivity.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    public static boolean handleOptionsItemSelected(Activity activity, MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            
        }
        return false;
    }
}