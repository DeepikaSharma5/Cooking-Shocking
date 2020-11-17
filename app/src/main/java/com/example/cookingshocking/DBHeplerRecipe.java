package com.example.cookingshocking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHeplerRecipe extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "recipe.db";
    private static final String TABLE_NAME = "recipe";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DES = "description";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_ING = "ingredient";
    SQLiteDatabase db;

    public static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + "(" + COLUMN_ID + " integer primary key autoincrement, " +
            COLUMN_NAME + " text not null, " + COLUMN_DES + " text not null, " +
            COLUMN_TIME + " text not null,"  + COLUMN_ING + " text not null);";

    public DBHeplerRecipe(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase database) {
        //Create Table when oncreate gets called
        database.execSQL(DATABASE_CREATE);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //if (oldVersion > 1) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        //}
    }

    public boolean addRecipe(String name, String description, String time, String ingredient) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(COLUMN_NAME, name);
        c.put(COLUMN_DES, description);
        c.put(COLUMN_TIME, time);
        c.put(COLUMN_ING, ingredient);
        long result = db.insert(TABLE_NAME, null, c);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Cursor getRecipe(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;

    }

    public Cursor getId(String name, String description, String ingredient, String time){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COLUMN_ID + " FROM "+ TABLE_NAME + "WHERE "
                + COLUMN_NAME + " = " + name + " AND " + COLUMN_DES + " = " + description +
                " AND " + COLUMN_ING + " = " +ingredient + " AND " + COLUMN_TIME + " = "
                + time + "''";
        Cursor data = db.rawQuery(query,null);
        return data;
    }
}
