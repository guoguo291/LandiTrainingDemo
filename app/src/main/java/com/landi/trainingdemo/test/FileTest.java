package com.landi.trainingdemo.test;

import com.landi.trainingdemo.bean.Animal;
import com.landi.trainingdemo.bean.Dog;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by guoj on 2019/6/2.
 */

public class FileTest {
    public static void main(String[] args) {
//        File file=new File("e:/ajavatest/landi/landiInfo.txt");
////        checkIsFile(file);
//        System.out.println("getAbsolutePath   "+file.getAbsolutePath());
//        System.out.println("getParent   "+file.getParent());
//        System.out.println("getPath   "+file.getPath());


    }
    static void checkIsFile(File file){
        if (file.exists()){
            File[] files=file.listFiles();
            if(files!=null&&files.length>0){
                for (File f:files) {
                    if(f.isFile()){
                        System.out.println(f.getName());
                    }else{
                        checkIsFile(f);
                    }
                }
            }
        }
    }
}
