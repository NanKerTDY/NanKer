package com.ztb.nanke;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nanker on 2017/4/24.
 */

public class MySqLiteHelper extends SQLiteOpenHelper {
    public static final String CREAT_PEPOLES = "CREATE table pepoles(" +
            "_id integer primary key autoincrement ," +
            "name text ," +
            "gender text ," +
            "age integer ," +
            "phone integer " +
            ")";
//    public static final String CREAT_PEPOLES =  "CREATE table pepoles(_id integer primary key autoincrement , name varchar(20) ,age integer , phone integer )";

    public MySqLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_PEPOLES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
