package com.landi.trainingdemo.pattern.absfactory;

/**
 * Created by guoj on 2019/8/23.
 */

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw");
    }
}