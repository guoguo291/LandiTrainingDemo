package com.landi.trainingdemo.serialization;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.ConcurrentModificationException;

/**
 * Created by guoj on 2019/5/26.
 */

public class Student implements Serializable{
    public String name;
    public transient int age;
    private PersonalInfo personalInfo;
    private static final long serialVersionUID = 1L;
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public Student() {
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student(String name, int age,PersonalInfo personalInfo) {
        this.name = name;
        this.age = age;
        this.personalInfo=personalInfo;
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


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", personalInfo=" +"address:"+ personalInfo.getAddress() +"phone:"+personalInfo.getPhone()+
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }
    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException{
//        s.defaultWriteObject();//把能默认进行序列化的属性序列化
        s.writeUTF(name);
        s.writeInt(age);//自己完成age的序列化
        s.writeUTF(this.personalInfo.getAddress());
        s.writeUTF(this.personalInfo.getPhone());
    }
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
//        s.defaultReadObject();
        this.name=s.readUTF();
        this.age=s.readInt();//自己完成age的反序列化
        this.personalInfo=new PersonalInfo(s.readUTF(),s.readUTF());
    }
}
