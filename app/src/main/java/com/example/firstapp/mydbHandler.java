package com.example.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class mydbHandler extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DATABASE_NAME = "prayer_db";
    public static final String TABLE_NAME = "model";

    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_PRAYER = "prayer";
    public static final String COLUMN_PRAYED = "prayed";
    public static final String COLUMN_RAKAT = "raket";
    public static final String COLUMN_JAMAT = "jamat";

    public mydbHandler(Context context)
    {
        super(context, DATABASE_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate( SQLiteDatabase db) {
        String sql = "CREATE TABLE  IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_DATE + " TEXT ,"
                + COLUMN_PRAYER + " TEXT,"
                + COLUMN_PRAYED + " TEXT,"
                + COLUMN_RAKAT + " TEXT,"
                + COLUMN_JAMAT + " TEXT,"
                + "PRIMARY KEY (" + COLUMN_DATE + "," + COLUMN_PRAYER + "))";
        db.execSQL(sql);
        Log.d("DBCreation","on create called " + sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public  void insertNamaz(Model md)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE,md.getDate());
        values.put(COLUMN_PRAYER,md.getPrayer());
        values.put(COLUMN_PRAYED,md.getPrayed());
        values.put(COLUMN_RAKAT,md.getRakat());
        values.put(COLUMN_JAMAT,md.getJamat());

        db.insert(TABLE_NAME,null,values);
        db.close();
        Log.d("Insertion Mode","on insert called " );
    }

//    public int updateStudent(Model md)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_DATE,md.getDate());
//        values.put(COLUMN_PRAYER,md.getPrayer());
//        values.put(COLUMN_PRAYED,md.getPrayed());
//        values.put(COLUMN_RAKAT,md.getRakat());
//        values.put(COLUMN_JAMAT,md.getJamat());
//
//        return db.update(Params.S_TABLE_NAME,values,Params.S_COLUMN_ID + " = ?", new String[]{String.valueOf(std.getId())});
//    }
//

    public List<Model> getAllData()
    {
        List<Model> model = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query= "SELECT * FROM "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst())
        {
            do {
                Model md = new Model();
                md.setDate(cursor.getString(0));
                md.setPrayer(cursor.getString(1));
                md.setPrayed(cursor.getString(2));
                md.setRakat(cursor.getString(3));
                md.setJamat(cursor.getString(4));

                model.add(md);
            }while (cursor.moveToNext());
        }
        Log.d("Selection Method","on Selectiong " );
        return model;
    }
}

