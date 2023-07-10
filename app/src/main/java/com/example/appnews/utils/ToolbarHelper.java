package com.example.appnews.utils;

import android.app.Activity;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.appnews.R;
import com.example.appnews.fragments.CategoryListFragment;

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

    public static boolean handleOptionsItemSelected(Activity activity, MenuItem item, FragmentManager fragmentManager, int fragmentContainerId) {
        if (item.getItemId() == R.id.action_categories) {
            Fragment currentFragment = getCurrentFragment(fragmentManager, fragmentContainerId);
            // Abre el fragmento de categorías
            if (currentFragment instanceof CategoryListFragment) {
                Log.d("ToolbarHelper", "Ya está abierto el fragmento de categorías");
            } else {
                openCategoryList(fragmentManager);
                Log.d("ToolbarHelper", "Abriendo el fragmento de categorías");
            }
            return true;
        }
        return false;
    }

    public static void openCategoryList(FragmentManager fragmentManager) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new CategoryListFragment())
                .addToBackStack(null)
                .commit();
    }

    private static Fragment getCurrentFragment(FragmentManager fragmentManager, int fragmentContainerId) {
        return fragmentManager.findFragmentById(fragmentContainerId);
    }

}