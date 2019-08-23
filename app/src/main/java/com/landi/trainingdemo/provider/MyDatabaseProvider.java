package com.landi.trainingdemo.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.landi.trainingdemo.db.MyDatabaseHelper;

/**
 * Created by guoj on 2019/7/28.
 */

public class MyDatabaseProvider extends ContentProvider {
    public static final int BOOK_DIR = 0;
    public static final int BOOK_ITEM = 1;
    public static final int CATEGORY_DIR = 2;
    public static final int CATEGORY_ITEM = 3;
    public static final String AUTHORITY = "com.landi.trainingdemo.provider";
    public static UriMatcher uriMatcher;
    MyDatabaseHelper myDatabaseHelper;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "book", BOOK_DIR);
        uriMatcher.addURI(AUTHORITY, "book/#", BOOK_ITEM);
        uriMatcher.addURI(AUTHORITY, "category", CATEGORY_DIR);
        uriMatcher.addURI(AUTHORITY, "category/#", CATEGORY_ITEM);
    }

    @Override
    public boolean onCreate() {
        myDatabaseHelper = new MyDatabaseHelper(getContext(), "BookStore.db", null, 3);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = myDatabaseHelper.getReadableDatabase();
        Cursor cursor = null;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                cursor=db.query("Book",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case BOOK_ITEM:
                String bookID=uri.getPathSegments().get(1);
                cursor=db.query("Book",projection,"id=?",new String[]{bookID},null,null,sortOrder);
                break;
            case CATEGORY_DIR:
                cursor=db.query("Category",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case CATEGORY_ITEM:
                String categoryID=uri.getPathSegments().get(1);
                cursor=db.query("Category",projection,"id=?",new String[]{categoryID},null,null,sortOrder);
                break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        Uri uriReturn = null;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
            case BOOK_ITEM:
                long newBookID=db.insert("Book",null,values);
                uriReturn=Uri.parse("content://"+AUTHORITY+"/book/"+newBookID);
                break;
            case CATEGORY_DIR:
            case CATEGORY_ITEM:
                String categoryID=uri.getPathSegments().get(1);
                long newCategoryID=db.insert("Category",null,values);
                uriReturn=Uri.parse("content://"+AUTHORITY+"/category/"+newCategoryID);
                break;
        }
        return uriReturn;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        int deleteRows=0;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                deleteRows=db.delete("Book",selection,selectionArgs);
                break;
            case BOOK_ITEM:
                String bookID=uri.getPathSegments().get(1);
                deleteRows=db.delete("Book","id=?",new String[]{bookID});
                break;
            case CATEGORY_DIR:
                deleteRows=db.delete("Category",selection,selectionArgs);
                break;
            case CATEGORY_ITEM:
                String categoryID=uri.getPathSegments().get(1);
                deleteRows=db.delete("Category","id=?",new String[]{categoryID});
                break;
        }
        return deleteRows;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        int updateRows=0;
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                updateRows=db.update("Book",values,selection,selectionArgs);
                break;
            case BOOK_ITEM:
                String bookID=uri.getPathSegments().get(1);
                updateRows=db.update("Book",values,"id=?",new String[]{bookID});
                break;
            case CATEGORY_DIR:
                updateRows=db.update("Category",values,selection,selectionArgs);
                break;
            case CATEGORY_ITEM:
                String categoryID=uri.getPathSegments().get(1);
                updateRows=db.update("Category",values,"id=?",new String[]{categoryID});
                break;
        }
        return updateRows;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                return "vnd.android.cursor.dir/vnd.com.landi.trainingdemo.provider.book";
            case BOOK_ITEM:
                return "vnd.android.cursor.item/vnd.com.landi.trainingdemo.provider.book";
            case CATEGORY_DIR:
                return "vnd.android.cursor.dir/vnd.com.landi.trainingdemo.provider.category";
            case CATEGORY_ITEM:
                return "vnd.android.cursor.item/vnd.com.landi.trainingdemo.provider.category";
        }
        return null;
    }
}
