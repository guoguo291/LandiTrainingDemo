package com.landi.trainingdemo.pattern.template;

/**
 * Created by guoj on 2019/8/23.
 */

public class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("加入85度热水泡茶叶");
    }

    @Override
    protected void addCondiment() {
        System.out.println("加入柠檬蜂蜜");
    }
}
