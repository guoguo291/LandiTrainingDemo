package com.landi.trainingdemo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by guoj on 2019/7/12.
 */

public class FileInputStreamDemo {
    public static void main(String[] args){
        File file=new File("E:/ajavatest/a.txt");
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            byte[] bytes=new byte[1024];
            while(fileInputStream.read()!=-1){
                System.out.print(new String(bytes));
            }
        } catch (FileNotFoundException e) {
            System.out.println("没有文件");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
