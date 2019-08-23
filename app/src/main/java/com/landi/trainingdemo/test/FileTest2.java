package com.landi.trainingdemo.test;

import java.io.File;
import java.io.IOException;

/**
 * Created by guoj on 2019/7/12.
 */

public class FileTest2 {
    public static void main(String[] args) {
        File file = new File("e:/ajavatest2/java/test.txt");
        //创建指定文件夹
        file.mkdirs();
        //创建文件
        try {
//            if (!file.exists()) {
                file.createNewFile();
//            }
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file2 = new File("e:/ajavatest");
        showAllFile(file2);
    }

    public static void showAllFile(File file) {
        //1.文件是否存在
        //2.遍历File对象判断是文件  如果是文件夹继续遍历
        if (file != null && file.exists()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        showAllFile(files[i]);
                    } else if(files[i].isFile()){
                        System.out.println(files[i].getName());
                    }
                }
            }
        }
    }
}
