package com.landi.trainingdemo.pattern.decorator;

/**
 * Created by guoj on 2019/6/2
 */

public class PhoneTest {
    public static void main(String[] args){
        Phone phone=new Phone();
        phone.call();
        System.out.println("升级后---------------");
        VideoPhone videoPhone=new VideoPhone(new Phone());
        videoPhone.call();
    }
}
