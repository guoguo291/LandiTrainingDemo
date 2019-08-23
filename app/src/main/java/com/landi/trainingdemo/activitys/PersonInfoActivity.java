package com.landi.trainingdemo.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.landi.trainingdemo.R;
import com.landi.trainingdemo.Utils;
import com.landi.trainingdemo.annotation.BindView;
import com.landi.trainingdemo.bean.Doctor;
import com.landi.trainingdemo.bean.Teacher;

public class PersonInfoActivity extends BaseActivity {
    @BindView(R.id.tv_obj_info)
    TextView tv_obj_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        Utils.injectView(this);
        Intent intent=getIntent();
        showInfo(intent);

    }

    private void showInfo(Intent intent) {
        StringBuilder stringBuilder=new StringBuilder();
        Teacher teacher=intent.getParcelableExtra("teacher");
        if (teacher!=null){
            stringBuilder.append("老师  姓名："+teacher.getName()+"  年龄:"+teacher.getAge()+"\n");
            tv_obj_info.setText(stringBuilder.toString());
        }
        Doctor doctor= (Doctor) intent.getSerializableExtra("doctor");
        if(doctor!=null){
            stringBuilder.append("医生  姓名："+doctor.getName()+"  年龄:"+doctor.getAge()+"\n");
            tv_obj_info.setText(stringBuilder.toString());
        }
    }
}
