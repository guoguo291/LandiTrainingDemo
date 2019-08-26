package com.landi.trainingdemo.pattern.proxy.dynamic;

/**
 * Created by guoj on 2019/8/26.
 */

public class Subject implements Color,Shape{
    @Override
    public void fill(String color) {
        System.out.println("物品颜色："+color);
    }

    @Override
    public void draw(String shape) {
        System.out.println("物品形状："+shape);
    }
}
