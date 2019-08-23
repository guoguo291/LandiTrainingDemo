package com.landi.trainingdemo.pattern.absfactory;

/**
 * Created by guoj on 2019/8/23.
 */

public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Blue::fill() method.");
    }
}
