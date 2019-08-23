package com.landi.trainingdemo.activitys;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.landi.trainingdemo.R;
import com.landi.trainingdemo.Utils;
import com.landi.trainingdemo.annotation.BindView;
import com.landi.trainingdemo.db.MyDatabaseHelper;

import javax.security.auth.login.LoginException;

public class DatabaseMenuActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG ="DatabaseMenuActivity" ;
    @BindView(R.id.id_btn_create_db)
    Button btn_create_db;
    @BindView(R.id.id_btn_update_db)
    Button btn_update_db;
    @BindView(R.id.id_btn_db_insert)
    Button btn_db_insert;
    @BindView(R.id.id_btn_db_delete)
    Button btn_db_delete;
    @BindView(R.id.id_btn_db_update)
    Button btn_db_update;
    @BindView(R.id.id_btn_db_query)
    Button btn_db_query;
    private MyDatabaseHelper myDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_database);
        initView();
        myDatabaseHelper=new MyDatabaseHelper(this,"BookStore.db",null,3);
    }

    private void initView() {
        Utils.injectView(this);
        btn_create_db.setOnClickListener(this);
        btn_update_db.setOnClickListener(this);
        btn_db_insert.setOnClickListener(this);
        btn_db_delete.setOnClickListener(this);
        btn_db_update.setOnClickListener(this);
        btn_db_query.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_btn_create_db:

                myDatabaseHelper.getWritableDatabase();
                break;
            case R.id.id_btn_update_db:
                myDatabaseHelper=new MyDatabaseHelper(this,"BookStore.db",null,3);
                myDatabaseHelper.getWritableDatabase();
                break;
            case R.id.id_btn_db_insert:

                SQLiteDatabase database=myDatabaseHelper.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put("name","西游记");
                contentValues.put("author","吴承恩");
                contentValues.put("pages",300);
                contentValues.put("price",29.98);
                database.insert("Book",null,contentValues);
                contentValues.clear();
                contentValues.put("name","西游记精装");
                contentValues.put("author","吴承恩");
                contentValues.put("pages",400);
                contentValues.put("price",29.98);
                database.insert("Book",null,contentValues);
                contentValues.clear();
                contentValues.put("name","JAVA");
                contentValues.put("author","Oricle");
                contentValues.put("pages",500);
                contentValues.put("price",69.98);
                database.insert("Book",null,contentValues);
                Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_btn_db_delete:
                SQLiteDatabase database2=myDatabaseHelper.getWritableDatabase();
                database2.delete("Book","name=? and pages>?",new String[]{"西游记精装","300"});
                break;
            case R.id.id_btn_db_update:
                SQLiteDatabase database3=myDatabaseHelper.getWritableDatabase();
                ContentValues contentValues1=new ContentValues();
                contentValues1.put("pages",600);
                contentValues1.put("price",99.98);
                database3.update("Book",contentValues1,"name=?",new String[]{"JAVA"});
                break;
            case R.id.id_btn_db_query:
                SQLiteDatabase database4=myDatabaseHelper.getWritableDatabase();
                Cursor cursor=database4.query("Book",null,"name=?",new String[]{"西游记"},null,null,null);
//                Cursor cursor=database4.rawQuery("select * from Book where name = ?",new String[]{"西游记"});
                if(cursor.moveToFirst()){
                    do {
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String author=cursor.getString(cursor.getColumnIndex("author"));
                        double price=cursor.getDouble(cursor.getColumnIndex("price"));
                        int pages=cursor.getInt(cursor.getColumnIndex("pages"));
                        Log.i(TAG, "name: "+name);
                        Log.i(TAG, "author"+author);
                        Log.i(TAG, "price"+price);
                        Log.i(TAG, "pages"+pages);
                        Log.i(TAG, "--------------------");
                    }while(cursor.moveToNext());
                    cursor.close();
                }
                break;
        }
    }
}
