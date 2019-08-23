package com.guo.providertest;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.guo.providertest.annotation.BindView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG ="MainActivity" ;
    @BindView(R.id.id_btn_db_insert)
    Button btn_db_insert;
    @BindView(R.id.id_btn_db_delete)
    Button btn_db_delete;
    @BindView(R.id.id_btn_db_update)
    Button btn_db_update;
    @BindView(R.id.id_btn_db_query)
    Button btn_db_query;
    private String newID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Utils.injectView(this);
        btn_db_insert.setOnClickListener(this);
        btn_db_delete.setOnClickListener(this);
        btn_db_update.setOnClickListener(this);
        btn_db_query.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.id_btn_db_insert:
                    Uri uri= Uri.parse("content://com.landi.trainingdemo.provider/book");
                    ContentValues contentValues=new ContentValues();
                    contentValues.put("name","西游记");
                    contentValues.put("author","吴承恩");
                    contentValues.put("pages",300);
                    contentValues.put("price",29.98);
                    Uri newUri=getContentResolver().insert(uri,contentValues);
                    newID=newUri.getPathSegments().get(1);
//                    contentValues.clear();
//                    contentValues=new ContentValues();
//                    contentValues.put("name","西游记2");
//                    contentValues.put("author","吴承恩");
//                    contentValues.put("pages",300);
//                    contentValues.put("price",29.98);
//                    newUri=getContentResolver().insert(uri,contentValues);
                    break;
                case R.id.id_btn_db_query:
                    Uri uri1= Uri.parse("content://com.landi.trainingdemo.provider/book");
                    Cursor cursor=getContentResolver().query(uri1,null,null,null,null);
                    if(cursor!=null){

                        if (cursor.moveToFirst()) {
                            do {
                                int id=cursor.getInt(cursor.getColumnIndex("id"));
                                String name = cursor.getString(cursor.getColumnIndex("name"));
                                String author = cursor.getString(cursor.getColumnIndex("author"));
                                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                                Log.i(TAG, "id: " + id);
                                Log.i(TAG, "name: " + name);
                                Log.i(TAG, "author" + author);
                                Log.i(TAG, "price" + price);
                                Log.i(TAG, "pages" + pages);
                                Log.i(TAG, "--------------------");
                            } while (cursor.moveToNext());
                            cursor.close();
                        }
                    }
                    break;
                case R.id.id_btn_db_delete:
                    Uri uri2= Uri.parse("content://com.landi.trainingdemo.provider/book/"+"2");
                    getContentResolver().delete(uri2,null,null);
                    break;
                case R.id.id_btn_db_update:
                    Uri uri3= Uri.parse("content://com.landi.trainingdemo.provider/book/");
                    ContentValues contentValues1=new ContentValues();
                    contentValues1.put("name","西游记精装版");
                    contentValues1.put("pages",600);
                    contentValues1.put("price",99.98);
                    getContentResolver().update(uri3,contentValues1,"name=?",new String[]{"西游记"});
                    break;
            }
        }
}
