package com.example.otlistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BHDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sql.db";
    private static final String TABLE_NAME = "bh";
    private static final String id = "id";
    private static final String anh = "anh";
    private static final String thich = "thich";
    private static final String ten = "ten";
    private static final String casi = "casi";

    public BHDatabase(@Nullable Context contextactory) {
        super(contextactory, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists bh(id integer primary key autoincrement, anh integer, thich interger, ten text, casi text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void themBH(BHModel object) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(id, object.getId());
        values.put(anh, object.getAnh());
        values.put(thich, object.getLike());
        values.put(ten, object.getTen());
        values.put(casi, object.getCasi());
        database.insert(TABLE_NAME, null, values);
        database.close();
    }

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }
}
