package com.example.shubham.minorproject;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created on 25-09-2017.
 */

public class AppOpenHelper extends SQLiteOpenHelper {

    public static final String DB_TABLENAME ="tracking_product";
    public static final String DB_TITLE ="title";
    public static final String DB_PRICE ="price";
    public static final String DB_REFID ="id";
    public static final String DB_IMAGE ="image";

    public AppOpenHelper(Context context) {
        super(context, "ProductTracker.db", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query="create table "+DB_TABLENAME+" ( "+DB_TITLE+" text, "+DB_PRICE+" text, "+DB_REFID+" text, "+DB_IMAGE+" text );";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
