package com.landi.trainingdemo.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by guoj on 2019/5/26.
 */

public class DataInputStreamDemo {
    public static void main(String[] args){
        try {
            DataInputStream is=new DataInputStream(new FileInputStream("e:/ajavatest/a.txt"));
            byte[] bytes=new byte[1024];
            while (is.read(bytes)!=-1){
//                System.out.print(Integer.toHexString(i));
                String s=new String(bytes,"utf-8");
                System.out.println(s);
            };
//            System.out.print(is.readBoolean());
//            System.out.print(is.readChar());
            //关闭流
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
