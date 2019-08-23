package com.landi.trainingdemo.file;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by guoj on 2019/5/25.
 */

public class FileTest {
    public static  void main(String[] args){
//        File file=new File("e:/ajavatest/youchu");
        File file=new File("e:/ajavatest/youchu/bank");
        System.out.println("file.isDirectory():"+file.isDirectory());
        System.out.println("file.exists():"+file.exists());
        if(!file.exists()){
//            file.mkdir();
            file.mkdirs();
        }else{
            System.out.println("文件夹已经存在！");
        }
        File file1=new File(file,"pay.txt");
        if(!file1.exists()){
            file1.mkdir();
        }else{
            System.out.println("文件夹已经存在！");
        }


//        File file2=new File("e:/ajavatest/a.txt");
//        File file=new File("e:\\ajavatest\\b.txt");
//        File file=new File("e:/ajavatest/youchu/c.txt");
        File file2=null;
        try {
            URI uri=new URI("file:///e:/ajavatest/urr.txt");
            file2=new File(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if(!file2.exists()){
            try {
                file2.createNewFile();
                System.out.println("创建新文件");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
//            file2.delete();
            System.out.println("文件已经存在！");
            System.out.println("file.isDirectory():"+file.isDirectory());
            System.out.println("file.isFile:"+file.isFile());
            System.out.println("file2.isDirectory():"+file2.isDirectory());
            System.out.println("file2.isFile:"+file2.isFile());
        }

    }
}
