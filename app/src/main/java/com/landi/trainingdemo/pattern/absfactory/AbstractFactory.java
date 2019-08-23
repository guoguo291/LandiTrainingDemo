package com.landi.trainingdemo.pattern.absfactory;

/**
 * Created by guoj on 2019/8/23.
 */

public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
