package com.landi.trainingdemo.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by guoj on 2019/6/6.
 */

public class Student {
    @JSONField(ordinal = 1)
    private String name;
    @JSONField(ordinal = 2)
    private int age;
    @JSONField(ordinal = 3)
    private boolean sex;

    public Student(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
