package com.landi.trainingdemo.pattern.absfactory;

/**
 * Created by guoj on 2019/8/23.
 */

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle.draw");
    }
}
