package com.landi.trainingdemo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by guoj on 2019/8/21.
 */

public class Teacher implements Parcelable{
    String name;
    int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected Teacher(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<Teacher> CREATOR = new Creator<Teacher>() {
        @Override
        public Teacher createFromParcel(Parcel in) {
            return new Teacher(in);
        }

        @Override
        public Teacher[] newArray(int size) {
            return new Teacher[size];
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
}
