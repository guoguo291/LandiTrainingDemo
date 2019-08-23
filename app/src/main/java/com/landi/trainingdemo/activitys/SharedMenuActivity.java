package com.landi.trainingdemo.activitys;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.landi.trainingdemo.R;
import com.landi.trainingdemo.Utils;
import com.landi.trainingdemo.annotation.BindView;
import com.tencent.mmkv.MMKV;

public class SharedMenuActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "SharedMenuActivity";
    @BindView(R.id.id_btn_save_info)
    Button button_save;
    @BindView(R.id.id_btn_get_shared)
    Button button_getInfo;
    MMKV mmkv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_shared);
        initView();
    }
    private void initView() {
        Utils.injectView(this);
        button_getInfo.setOnClickListener(this);
        button_save.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_btn_save_info:
//                SharedPreferences sharedPreferences=getSharedPreferences("myshared",MODE_PRIVATE);
//                SharedPreferences.Editor editor=sharedPreferences.edit();
//                editor.putString("name","小米");
//                editor.putBoolean("sex",true);
//                editor.putInt("age",27);
//                editor.apply();
//                Toast.makeText(SharedMenuActivity.this,"保存成功!",Toast.LENGTH_SHORT).show();
//                editor.commit();

                mmkv= MMKV.defaultMMKV();
//                mmkv.encode("name","小红");

                new Thread(new Runnable() {
                @Override
                public void run() {
                    long start=System.currentTimeMillis();
                    for (int i=0;i<1000;i++){
                        mmkv.encode(String.valueOf(i),String.valueOf(i));
                    }
                    long end=System.currentTimeMillis();
                    long time=end-start;
                    Log.i(TAG, "MMKV耗时: "+time);
//                    SharedPreferences sharedPreferences=getSharedPreferences("myshared",MODE_PRIVATE);
//                    SharedPreferences.Editor editor=sharedPreferences.edit();
//                    long start1=System.currentTimeMillis();
//                    for (int i=0;i<1000;i++){
//                        editor.putString(String.valueOf(i),String.valueOf(i));
//                        editor.apply();
//                    }
//                    long end1=System.currentTimeMillis();
//                    long time1=end1-start1;
//                    Log.i(TAG, "SharedPrefrences耗时: "+time1);
                }
            }).start();

                break;
            case R.id.id_btn_get_shared:
//                SharedPreferences sp=getSharedPreferences("myshared",MODE_PRIVATE);
//                String name=sp.getString("name","未知");
//                boolean sex=sp.getBoolean("sex",false);
//                int age=sp.getInt("age",0);
//                Log.i(TAG, "name: "+name+" sex:"+sex+" age:"+age);
                String value = mmkv.decodeString("name", null);
                Log.i(TAG, "name: "+value);
                break;

        }
    }
}
