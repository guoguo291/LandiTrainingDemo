package com.landi.trainingdemo.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.landi.trainingdemo.R;
import com.landi.trainingdemo.Utils;
import com.landi.trainingdemo.annotation.BindView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.xml.datatype.Duration;

public class FileMenuActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.id_edit)
    EditText editText;
    @BindView(R.id.id_btn_save)
    Button button_save;
    @BindView(R.id.id_btn_getinfo)
    Button button_getInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_file);
        Utils.injectView(this);
        initView();
    }

    private void initView() {
        button_getInfo.setOnClickListener(this);
        button_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_btn_save:
                String info = editText.getText().toString();
                if (info != null && !info.isEmpty()) {
                    FileOutputStream fileOutputStream = null;
                    BufferedWriter bufferedWriter = null;
                    try {
                        fileOutputStream = openFileOutput("mydata", MODE_PRIVATE);
                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                        bufferedWriter.write(info);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case R.id.id_btn_getinfo:
                FileInputStream fileInputStream=null;
                BufferedReader bufferedReader=null;
                try {
                    fileInputStream=openFileInput("mydata");
                    bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));
                    StringBuilder stringBuilder=new StringBuilder();
                    String s;
                    while ((s=bufferedReader.readLine())!=null){
                        stringBuilder.append(s);
                    }
                    if (stringBuilder.toString()!=null&&!stringBuilder.toString().isEmpty()){
                        editText.setText(stringBuilder.toString());
                        Toast.makeText(FileMenuActivity.this,"读取成功!",Toast.LENGTH_SHORT).show();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (bufferedReader!=null){
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;

        }
    }
}
