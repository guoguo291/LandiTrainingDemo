package com.landi.trainingdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by guoj on 2019/7/26.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_TABLE_BOOK = "create table Book(id integer primary key autoincrement,author text,price real,pages integer,name text)";
    public static final String CREATE_TABLE_CATEGORY= "create table Category(id integer primary key autoincrement,category_name text,category_code integer)";
    Context mContext;
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_BOOK);
//        db.execSQL(CREATE_TABLE_CATEGORY);
//        Toast.makeText(mContext,"创建成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

//        db.execSQL("drop table if exists Book");
//        db.execSQL("drop table if exists Category");
//        onCreate(db);
//        db.execSQL(CREATE_TABLE_CATEGORY);
        db.execSQL("alter table book add press text");
//        Toast.makeText(mContext,"数据库升级成功",Toast.LENGTH_SHORT).show();
    }
}
