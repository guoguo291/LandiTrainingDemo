package com.landi.trainingdemo.activitys;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.landi.trainingdemo.MainActivity;
import com.landi.trainingdemo.R;
import com.landi.trainingdemo.Utils;
import com.landi.trainingdemo.annotation.BindView;

public class ContentProviderMenuActivity extends AppCompatActivity {
    private static final String TAG = "ContentProviderMenuActivity";
    @BindView(R.id.id_btn_get_contactsInfo)
    Button button_get_contacts;
    @BindView(R.id.id_btn_get_contentProvider)
    Button button_get_contentProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_content_provider);
        initView();
    }

    private void initView() {
        Utils.injectView(this);
        button_get_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContentProviderMenuActivity.this, ContactsInfoActivity.class));
            }
        });
        button_get_contentProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }




}
