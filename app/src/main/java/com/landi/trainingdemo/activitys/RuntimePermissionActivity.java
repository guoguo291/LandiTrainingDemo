package com.landi.trainingdemo.activitys;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.landi.trainingdemo.R;
import com.landi.trainingdemo.Utils;
import com.landi.trainingdemo.annotation.BindView;
import com.tencent.mmkv.MMKV;

public class RuntimePermissionActivity extends AppCompatActivity {
    private static final String TAG = "RuntimePermissionActivity";
    @BindView(R.id.id_btn_call)
    Button button_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_permission);
        initView();
    }

    private void initView() {
        Utils.injectView(this);
        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });

    }

    private void call() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(RuntimePermissionActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
            return;
        }
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:10086"));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    call();
                }else {
                    Toast.makeText(this,"Permission Deny",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
