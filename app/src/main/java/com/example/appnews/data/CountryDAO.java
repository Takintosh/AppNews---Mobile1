package com.example.appnews.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appnews.models.Country;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {

    private SQLiteDatabase db;

    public CountryDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public long insertCountry(Country country) {
        ContentValues values = new ContentValues();
        values.put("country_name", country.getCountryName());
        values.put("iso_code", country.getCountryCode());
        return db.insert("countries", null, values);
    }

    public Country getCountry(int countryId) {
        String[] projection = {"id", "country_name", "iso_code"};
        String selection = "id = ?";
        String[] selectionArgs = {String.valueOf(countryId)};

        Cursor cursor = db.query("countries", projection, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            Country country = new Country();
            country.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            country.setCountryName(cursor.getString(cursor.getColumnIndexOrThrow("country_name")));
            country.setCountryCode(cursor.getString(cursor.getColumnIndexOrThrow("iso_code")));
            cursor.close();
            return country;
        } else {
            cursor.close();
            return null;
        }
    }

    public List<Country> listCountries() {
        List<Country> listCountries = new ArrayList<>();
        String[] projection = {"id", "country_name", "iso_code"};

        Cursor cursor = db.query("countries", projection, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Country country = new Country();
            country.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
            country.setCountryName(cursor.getString(cursor.getColumnIndexOrThrow("country_name")));
            country.setCountryCode(cursor.getString(cursor.getColumnIndexOrThrow("iso_code")));

            listCountries.add(country);
        }
        cursor.close();
        return listCountries;
    }

}
