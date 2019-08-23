package com.landi.trainingdemo.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by guoj on 2019/5/26.
 */

public class FileReaderDemo {
    public static void main(String[] args){
        try {
            BufferedReader br=new BufferedReader(new FileReader("e:/ajavatest/a.txt"));
            String line;
            while ((line=br.readLine())!=null){
                System.out.println(line);
            }
            br.close();

           /* FileReader is=new FileReader("e:/ajavatest/a.txt");
            int i;
            char[] chars=new char[1024];
            while ((i=is.read(chars))!=-1){
                System.out.print(Integer.toHexString(i&0xff));
                for (char c:chars){
                    System.out.println(c);
                }
            };
            is.close();*/

            /*InputStreamReader is=new InputStreamReader(new FileInputStream("e:/ajavatest/a.txt"),"utf-8");
            int i;
            char[] chars=new char[1024];
            while ((i=is.read(chars))!=-1){
                for (char c:chars){
                    System.out.print(c);
                }
            };
            is.close();*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
