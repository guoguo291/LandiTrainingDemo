package com.landi.trainingdemo.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by guoj on 2019/5/26.
 */

public class SerializationDemo {
    public static void main(String[] args){
        File file=new File("e:/ajavatest/student.ser");
//        objToFile(file);
        fileToObj(file);
    }
    public static void objToFile(File file){
        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
            PersonalInfo personalInfo=new PersonalInfo("北京","138888888");
            Student student=new Student("王老师",40,personalInfo);
            objectOutputStream.writeObject(student);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void fileToObj(File file){
        try {
            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(file));
            Student student=(Student) objectInputStream.readObject();
            System.out.print(student.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
