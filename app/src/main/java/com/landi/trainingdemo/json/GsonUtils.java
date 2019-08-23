package com.landi.trainingdemo.json;

import com.google.gson.Gson;
import com.landi.trainingdemo.bean.Group;
import com.landi.trainingdemo.bean.Student;

/**
 * Created by guoj on 2019/6/1.
 */

public class GsonUtils {
    public static void main(String[] args) {
//        jsonObj2str();
        jsonStr2obj();
    }

    private static void jsonObj2str() {
        Student student1=new Student("王小二",18,false);
        Student student2=new Student("海王",19,true);
        Group group=new Group();
        group.setGroupId(1);
        group.getStudents().add(student1);
        group.getStudents().add(student2);
        String jsonStr= new Gson().toJson(group);
        System.out.println(jsonStr);
    }
    private static void jsonStr2obj() {
        String json="{\"groupId\":1,\"students\":[{\"name\":\"王小二\",\"age\":18,\"sex\":false},{\"name\":\"海王\",\"age\":19,\"sex\":true}]}";
        Gson gson=new Gson();
        Group group=gson.fromJson(json,Group.class);
        System.out.println(group.toString());
    }
}
