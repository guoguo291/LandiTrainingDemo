package com.landi.trainingdemo.pattern.proxy.dynamic;

/**
 * Created by guoj on 2019/8/26.
 */

public class ProxyShape implements Shape{
    private Subject subject;
    @Override
    public void draw(String shape) {
        if (subject==null){
            subject=new Subject();
        }
        System.out.println("代理记录draw的时间："+System.currentTimeMillis());
        subject.draw(shape);
    }
}
