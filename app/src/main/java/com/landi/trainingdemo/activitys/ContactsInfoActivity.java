package com.landi.trainingdemo.activitys;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.landi.trainingdemo.R;
import com.landi.trainingdemo.Utils;
import com.landi.trainingdemo.annotation.BindView;

import java.util.ArrayList;

public class ContactsInfoActivity extends AppCompatActivity {
    private static final String TAG = "ContactsInfoActivity";
    @BindView(R.id.id_btn_get_contacts)
    Button button_get_contacts;
    @BindView(R.id.id_lv)
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> contactsList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        initView();
    }

    private void initView() {
        Utils.injectView(this);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactsList);
        listView.setAdapter(adapter);
        button_get_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContacts();
            }
        });

    }

    private void getContacts() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(ContactsInfoActivity.this,new String[]{Manifest.permission.READ_CONTACTS},1);
            return;
        }
        contactsList.clear();
        Cursor cursor= null;
        try{
            cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
            if (cursor!=null){
                while (cursor.moveToNext()) {
                    String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String phone=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    contactsList.add(name+"\n"+phone);
                }
                adapter.notifyDataSetChanged();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            cursor.close();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    getContacts();
                }else {
                    Toast.makeText(this,"Permission Deny",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
