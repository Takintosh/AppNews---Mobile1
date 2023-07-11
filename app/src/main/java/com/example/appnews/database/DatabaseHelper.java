package com.example.appnews.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "sql";
    private static final String DATABASE_NAME = "appnews.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Estructura de la base de datos
        Log.d(TAG, "Creando tablas...");
        db.execSQL("CREATE TABLE IF NOT EXISTS categories (id INTEGER PRIMARY KEY AUTOINCREMENT, category_name TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS countries (id INTEGER PRIMARY KEY AUTOINCREMENT, country_name TEXT, iso_code TEXT)");
        Log.d(TAG, "Tablas creadas. Insertando datos iniciales...");
        db.execSQL("INSERT INTO categories (category_name) VALUES ('Economia'), ('Deportes'), ('Politica'), ('Tecnologia'), ('Cultura')");
        db.execSQL("INSERT INTO countries (country_name, iso_code) VALUES ('Estados Unidos', 'US'), ('Brasil', 'BR'), ('Argentina', 'AR')");
        Log.d(TAG, "Datos iniciales insertados");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Acciones de actualización de la base de datos
    }

}
