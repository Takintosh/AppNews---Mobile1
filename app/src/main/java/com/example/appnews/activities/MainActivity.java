package com.example.appnews.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.appnews.R;
import com.example.appnews.utils.ToolbarHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        ToolbarHelper.setupToolbar(this, toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return ToolbarHelper.handleOptionsItemSelected(this, item) || super.onOptionsItemSelected(item);
    }

}