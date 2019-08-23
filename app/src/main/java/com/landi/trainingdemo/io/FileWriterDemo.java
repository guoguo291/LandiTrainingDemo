package com.landi.trainingdemo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by guoj on 2019/5/27.
 */

public class FileWriterDemo {
    public static void main(String[] args){
        try {
//            FileReader is=new FileReader("e:/ajavatest/fr.png");
//            FileWriter fw=new FileWriter("e:/ajavatest/fw.png");
//            FileReader is=new FileReader("e:/ajavatest/a.txt");
//            FileWriter fw=new FileWriter("e:/ajavatest/FileWriter.txt");

            InputStreamReader is=new InputStreamReader(new FileInputStream("e:/ajavatest/fr.png"));
            OutputStreamWriter fw=new OutputStreamWriter(new FileOutputStream("e:/ajavatest/fw.png"));
            int i;
            char[] chars=new char[1024];
            while ((i=is.read(chars))!=-1){
                fw.write(chars,0,i);
                fw.flush();
            }
            is.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 }
}
