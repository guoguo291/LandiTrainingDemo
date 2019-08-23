package com.landi.trainingdemo.bean;

import java.io.Serializable;

/**
 * Created by guoj on 2019/8/21.
 */

public class Doctor implements Serializable{
    private String name;
    private int age;
    private static final long serialVersionUID = 1L;
    public Doctor(String name, int age) {
        this.name = name;
        this.age = age;
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
}
