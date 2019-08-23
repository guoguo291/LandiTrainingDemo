package com.landi.trainingdemo;

import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.landi.trainingdemo.activitys.ContentProviderMenuActivity;
import com.landi.trainingdemo.activitys.DatabaseMenuActivity;
import com.landi.trainingdemo.activitys.FileMenuActivity;
import com.landi.trainingdemo.activitys.LitePalMenuActivity;
import com.landi.trainingdemo.activitys.PersonInfoActivity;
import com.landi.trainingdemo.activitys.RuntimePermissionActivity;
import com.landi.trainingdemo.activitys.SharedMenuActivity;
import com.landi.trainingdemo.annotation.BindView;
import com.landi.trainingdemo.bean.Doctor;
import com.landi.trainingdemo.bean.Teacher;
import com.landi.trainingdemo.http.HttpDemo;
import com.landi.trainingdemo.interfaces.LambdaTestInterface;
import com.landi.trainingdemo.interfaces.LambdaTestInterface2;
import com.landi.trainingdemo.pattern.adpter.ThreePlugIf;
import com.landi.trainingdemo.service.LongRunningService;

import java.util.Timer;
import java.util.TimerTask;

import javax.xml.transform.Transformer;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.tv_info)
    TextView tv_info;
    @BindView(R.id.id_btn_parse_json)
    Button btn_parse_json;
    @BindView(R.id.id_btn_database)
    Button btn_database_operation;
    @BindView(R.id.id_btn_sharedpre)
    Button btn_sharedpre_operation;
    @BindView(R.id.id_btn_file)
    Button btn_file_operation;
    @BindView(R.id.id_btn_litepal)
    Button btn_litepal_operation;
    @BindView(R.id.id_btn_runtime_permission)
    Button btn_runtime_permission;
    @BindView(R.id.id_btn_contentProvider)
    Button btn_contentProvider;
    @BindView(R.id.id_btn_transfer_object)
    Button btn_transfer_obj;
    @BindView(R.id.id_btn_alarm)
    Button btn_open_alarm;
    @BindView(R.id.id_lambda)
    Button btn_lambda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.injectView(this);
        btn_parse_json.setOnClickListener(this);
        btn_database_operation.setOnClickListener(this);
        btn_sharedpre_operation.setOnClickListener(this);
        btn_file_operation.setOnClickListener(this);
        btn_litepal_operation.setOnClickListener(this);
        btn_runtime_permission.setOnClickListener(this);
        btn_contentProvider.setOnClickListener(this);
        btn_transfer_obj.setOnClickListener(this);
        btn_open_alarm.setOnClickListener(this);
        btn_lambda.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_btn_parse_json:
//                String jsonData="[{\"name\":\"二阳\",\"age\":18,\"sex\":true},{\"name\":\"小2阳\",\"age\":19,\"sex\":false}]";
                String jsonData = "[{'name':'二阳','age':18,'sex':true},{'name':'小2阳','age':19,'sex':false}]";
//                JsonDemoUtils.parseJsonToObj(jsonData);
//                JsonDemoUtils.parseJsonToObj2();
//                JsonDemoUtils.jsonObj2String();
//                FastJsonUtils.jsonObj2str();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        HttpDemo.doHttpClientGet();
//                        HttpDemo.doHttpClientPost();
                    }
                }).start();
                break;
            case R.id.id_btn_database:
                startActivity(new Intent(MainActivity.this, DatabaseMenuActivity.class));
                break;
            case R.id.id_btn_sharedpre:
                startActivity(new Intent(MainActivity.this, SharedMenuActivity.class));
                break;
            case R.id.id_btn_file:
                startActivity(new Intent(MainActivity.this, FileMenuActivity.class));
                break;
            case R.id.id_btn_litepal:
                startActivity(new Intent(MainActivity.this, LitePalMenuActivity.class));
                break;
            case R.id.id_btn_runtime_permission:
                startActivity(new Intent(MainActivity.this, RuntimePermissionActivity.class));
                break;
            case R.id.id_btn_contentProvider:
                startActivity(new Intent(MainActivity.this, ContentProviderMenuActivity.class));
                break;
            case R.id.id_btn_transfer_object:
                Teacher teacher = new Teacher("刘翔", 28);
                Doctor doctor = new Doctor("华佗", 80);
                Intent intent = new Intent();
                intent.putExtra("teacher", teacher);
                intent.putExtra("doctor", doctor);
                intent.setClass(MainActivity.this, PersonInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.id_btn_alarm:

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        StringBuilder stringBuilder=new StringBuilder();
                        stringBuilder.append("Timer:");
                        stringBuilder.append(System.currentTimeMillis());
                        LogUtil.i("Timer", stringBuilder.toString() );
                    }
                }, 1000, 3000);
                startService(new Intent(MainActivity.this, LongRunningService.class));
                break;
            case R.id.id_lambda:
                LambdaTestInterface lambdaTestInterface = () -> Toast.makeText(MainActivity.this, "lambda is so cool", Toast.LENGTH_SHORT).show();
                lambdaTestInterface.show();
                LambdaTestInterface2 lambdaTestInterface2 = (a, b) -> {
                    String info = "name:" + a + "  age：" + b;
                    return info;
                };
                Timer timer2 = new Timer();
                timer2.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(() ->
                            Toast.makeText(MainActivity.this, lambdaTestInterface2.show("小花", 18), Toast.LENGTH_LONG).show());
                    }
                }, 2000);
                break;
        }
    }
}
