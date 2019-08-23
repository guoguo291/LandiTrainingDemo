package com.landi.trainingdemo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.landi.trainingdemo.bean.Group;
import com.landi.trainingdemo.bean.Student;
import java.util.List;

/**
 * Created by guoj on 2019/6/1.
 */

public class FastJsonUtils {
    public static void main(String[] args){
        jsonObj2str();
    }

    public static void jsonObj2str() {
        Student student1=new Student("王小二",18,false);
        Student student2=new Student("海王",19,true);
        Group group=new Group();
        group.setGroupId(1);
        group.getStudents().add(student1);
        group.getStudents().add(student2);
        String jsonStr= JSONObject.toJSONString(group);
        System.out.println(jsonStr);
        // JSON串转对象
//        Group group2 = JSON.parseObject(jsonStr, Group.class);
//        System.out.println("group2:" + group2.toString());
//        //数组转json串
//        Student[] groups=new Student[2];
//        groups[0]=student1;
//        groups[1]=student2;
//        String jsonStr2= JSONArray.toJSONString(groups);
//        System.out.println(jsonStr2);
//        List<Student> students=JSONArray.parseArray(jsonStr2,Student.class);
//        System.out.println(students);
    }

}
