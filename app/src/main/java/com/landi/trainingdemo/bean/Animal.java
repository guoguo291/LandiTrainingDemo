package com.landi.trainingdemo.bean;

/**
 * Created by guoj on 2019/8/15.
 */

public class Animal {

    public Animal(String name,String age){
        this.age=age;
        this.name=name;
    }
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
