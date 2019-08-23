package com.landi.trainingdemo.pattern.template;

/**
 * Created by guoj on 2019/8/23.
 */

public class Coffee extends Beverage {
    @Override
    protected boolean isCustomWantCondiment() {
        return false;
    }

    @Override
    protected void brew() {
        System.out.println("加入沸水冲咖啡");
    }

    @Override
    protected void addCondiment() {
        System.out.println("加入白糖");
    }
}
