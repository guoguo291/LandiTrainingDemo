package com.landi.trainingdemo.io;

import java.io.File;

/**
 * Created by guoj on 2019/5/25.
 */

public class IoTest {
    public static void main(String[] args){
        System.out.print("test...");
        String s="你好abc";
        byte[] bytes=s.getBytes();
        for (byte b:bytes){
            System.out.print(Integer.toHexString(b&0xff)+"");
        }
    }
}
