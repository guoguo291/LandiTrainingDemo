package com.landi.trainingdemo.pattern.proxy.dynamic;

/**
 * Created by guoj on 2019/8/26.
 */

public class ProxyColor implements Color{
    private Subject subject;
    @Override
    public void fill(String color) {
        if (subject==null){
            subject=new Subject();
        }
        System.out.println("代理记录fill的时间："+System.currentTimeMillis());
        subject.fill(color);
    }
}
