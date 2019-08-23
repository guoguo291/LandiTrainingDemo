package com.landi.trainingdemo.activitys;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.landi.trainingdemo.R;
import com.landi.trainingdemo.Utils;
import com.landi.trainingdemo.annotation.BindView;
import com.landi.trainingdemo.bean.Book;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class LitePalMenuActivity extends AppCompatActivity implements View.OnClickListener{
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_database);
        initView();

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
                Connector.getWritableDatabase();
                break;
            case R.id.id_btn_update_db:

                break;
            case R.id.id_btn_db_insert:
                Book book=new Book();
                book.setName("小王子");
                book.setAuthor("allen");
                book.setPages(200);
                book.setPrice(35.99);
                book.setPress("北京邮电");
                book.save();
                break;
            case R.id.id_btn_db_delete:
                LitePal.deleteAll(Book.class,"price<?","40");
                break;
            case R.id.id_btn_db_update:
                Book book1=new Book();
                book1.setName("小王子精装版");
                book1.setAuthor("allen");
                book1.setPages(200);
                book1.setPrice(35.99);
                book1.setPress("北京邮电");
                book1.save();
                book1.setPrice(99.99);
                book1.save();
                break;
            case R.id.id_btn_db_query:
//                List<Book> books=DataSupport.findAll(Book.class);
                List<Book> books=LitePal.where("price>?","40").find(Book.class);
                for (Book book2:books){
                    String name=book2.getName();
                    String author=book2.getAuthor();
                    int pages=book2.getPages();
                    double price=book2.getPrice();
                    String press=book2.getPress();
                    Log.i(TAG, "name: "+name);
                    Log.i(TAG, "author:"+author);
                    Log.i(TAG, "pages:"+pages);
                    Log.i(TAG, "price:"+price);
                    Log.i(TAG, "press:"+press);
                    Log.i(TAG, "-------------------");
                }
                break;
        }
    }
}
