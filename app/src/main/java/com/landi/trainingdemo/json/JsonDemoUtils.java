package com.landi.trainingdemo.json;


import com.landi.trainingdemo.bean.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


/**
 * Created by guoj on 2019/6/1.
 */

public class JsonDemoUtils {
    public static void main(String[] args){
        parseJsonToObj2();
    }
    public static void parseJsonToObj(String jsonData) {
//        String jsonData="[{'name':'二阳','age':18,'sex':true},{'name':'小2阳','age':19,'sex':false}]";
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String name = jsonObject.getString("name");
                int age = jsonObject.getInt("age");
                boolean sex = jsonObject.getBoolean("sex");
                Student student = new Student(name, age, sex);
                System.out.println(student.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void parseJsonToObj2() {
        String jsonData = "{'students':[{'name':'二阳','age':18,'sex':true},{'name':'小花','age':19,'sex':false}]}";
        JSONArray jsonArray = null;
        try {
            JSONObject students = new JSONObject(jsonData);
            jsonArray = students.getJSONArray("students");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String name = jsonObject.getString("name");
                int age = jsonObject.getInt("age");
                boolean sex = jsonObject.getBoolean("sex");
                Student student = new Student(name, age, sex);
                System.out.println(student.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void jsonObj2String() {

        try {
            JSONObject student = new JSONObject();
            student.put("name", "郭健");
            student.put("age", 20);
            student.put("sex", "男");
            System.out.println(student.toString());

            HashMap student1=new HashMap();
            student1.put("name", "凯龙");
            student1.put("age", 20);
            student1.put("sex", "男");
            JSONObject obj1 = new JSONObject(student1);
            System.out.println(student1.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
