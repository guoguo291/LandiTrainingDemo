package com.landi.trainingdemo.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by guoj on 2019/5/26.
 */

public class DataOutputStreamDemo {
    public static void main(String[] args){
        try {
            File file=new File("e:/ajavatest/c.dat");
            write(file);
            reads(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write(File file) throws IOException {
        DataOutputStream dos=new DataOutputStream(new FileOutputStream(file));
        dos.writeBoolean(false);
        dos.writeChar('A');
        dos.writeFloat(100.12f);
        dos.writeLong(50000);
        //关闭流
        dos.close();
    }

    public static void reads(File file){

        try{
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new  DataInputStream(fis);
            //使用read来读取数据时，不要写要读取的数据  ，读的数据要和写/                             //的数据顺序一样
            boolean b=dis.readBoolean();
            char c =dis.readChar();
            float f1=dis.readFloat();
            long  i = dis.readLong();
            System.out.println(b);
            System.out.println(c);
            System.out.println(f1);
            System.out.println(i);
            dis.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
