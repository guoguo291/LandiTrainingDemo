package com.landi.trainingdemo.file;

import java.io.File;

/**
 * Created by guoj on 2019/5/26.
 */

public class FileListDemo {
    public static  void main(String[] args){
        File file=new File("e:/ajavatest");
        showAllFiles(file);
    }
    public static void showAllFiles(File file){
        if (file.exists()){
            File[] files=file.listFiles();
            if (files!=null&&files.length>0){
                for (File file1:files){
                    if (file1.isDirectory()){
                        showAllFiles(file1);
                    }else{
                        System.out.println(file1.getName());
                    }
                }
            }
        }
    }
}
