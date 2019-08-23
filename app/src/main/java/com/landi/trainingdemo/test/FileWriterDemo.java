package com.landi.trainingdemo.test;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by guoj on 2019/7/12.
 */

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("E:/ajavatest/c.txt");
        File file2 = new File("E:/ajavatest/img.png");
//        FileInputStream fileInputStream=null;
//        FileOutputStream fileOutputStream=null;
//        try {
//             fileInputStream=new FileInputStream(file);
//             fileOutputStream=new FileOutputStream(file2);
//            byte[] bytes=new byte[1024];
//            while (fileInputStream.read(bytes)!=-1){
//                fileOutputStream.write(bytes);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if(fileOutputStream!=null&&fileOutputStream!=null){
//                try {
//                    fileInputStream.close();
//                    fileOutputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        DataOutputStream dataOutputStream=null;
        DataInputStream dataInputStream=null;
        try {
            dataOutputStream=new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeInt(5);
            dataOutputStream.writeUTF("你好");
            dataOutputStream.writeChar('a');
            dataInputStream=new DataInputStream(new FileInputStream(file));
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readChar());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (dataOutputStream!=null){
                dataOutputStream.close();
            }
            if (dataInputStream!=null){
                dataInputStream.close();
            }
        }

       /* FileReader fileReader=null;
            FileWriter fileWriter=null;

            try {
                fileReader=new FileReader(file);
                fileWriter=new FileWriter(file2);
                char[] chars=new char[1024];
                while (fileReader.read(chars)!=-1){
                    fileWriter.write(chars);
                };
                fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileWriter!=null&&fileReader!=null){
                try {
                    fileReader.close();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }

}
