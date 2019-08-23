package com.landi.trainingdemo.io;

import android.provider.ContactsContract;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by guoj on 2019/5/26.
 */

public class FileOutputStreamDemo {
    public static void main(String[] args){

//        File file_src=new File("e:/ajavatest/a.txt");
//        File file=new File("e:/ajavatest/d.txt");

//        File file_src=new File("e:/ajavatest/psbcpay.apk");
//        File file=new File("i:/psbcpay.apk");

        File file_src=new File("e:/ajavatest/fr.png");
        File file=new File("e:/ajavatest/fw.png");
//        copyByByte(file_src, file);
        copyByBytes(file_src, file);
//        copyByBuffer(file_src, file);
//        copyByDataOutputStream(file_src, file);



    }

    private static void copyByByte(File file_src, File file_des) {
        try {
            FileInputStream fis=new FileInputStream(file_src);
            FileOutputStream fos=new FileOutputStream(file_des);
            int i;
            long start=System.currentTimeMillis();
            while ((i=fis.read())!=-1){
                fos.write(i);
            }
            long end=System.currentTimeMillis();
            System.out.print(end-start);
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copyByDataOutputStream(File file_src, File file_des) {
        try {
            FileInputStream fis=new FileInputStream(file_src);
            DataOutputStream fos=new DataOutputStream(new FileOutputStream(file_des));
            int i;
            long start=System.currentTimeMillis();
            while ((i=fis.read())!=-1){
                fos.write(i);
            }
            long end=System.currentTimeMillis();
            System.out.print(end-start);
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copyByBuffer(File file_src, File file_des) {
        try {
            FileInputStream fis=new FileInputStream(file_src);
            BufferedOutputStream os=new BufferedOutputStream(new FileOutputStream(file_des));
            int i;
            long start=System.currentTimeMillis();
            while ((i=fis.read())!=-1){
                os.write(i);
                os.flush();
            }
            long end=System.currentTimeMillis();
            System.out.print(end-start);
            fis.close();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copyByBytes(File file_src, File file_des) {
        try {
            FileInputStream fis=new FileInputStream(file_src);
            FileOutputStream fos=new FileOutputStream(file_des);
            byte[] bytes=new byte[1024*2];
            long start=System.currentTimeMillis();
            while (fis.read(bytes)!=-1){
                fos.write(bytes,0,bytes.length);
            }
            long end=System.currentTimeMillis();
            System.out.print(end-start);
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
