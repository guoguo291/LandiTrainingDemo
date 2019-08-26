package com.landi.trainingdemo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 远程服务传输自定义对象数据，包名必须要和服务端对象类的包名一致
 * Created by guoj on 2019/8/16.
 */

public class Person implements Parcelable {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    protected Person(Parcel in) {
        this.name=in.readString();
        this.age=in.readInt();
    }
    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    @Override
    public String toString() {
        return "name:"+this.name+" age:"+this.age;
    }
}
