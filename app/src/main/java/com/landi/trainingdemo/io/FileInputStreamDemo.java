package com.landi.trainingdemo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by guoj on 2019/5/26.
 */

public class FileInputStreamDemo {
    public static void main(String[] args){
        try {
            FileInputStream is=new FileInputStream("e:/ajavatest/a.txt");
            int i;
            byte[] buf=new byte[1024];
            while ((i=is.read(buf))!=-1){
                System.out.print(Integer.toHexString(i&0xff));
            };
            //关闭流
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
