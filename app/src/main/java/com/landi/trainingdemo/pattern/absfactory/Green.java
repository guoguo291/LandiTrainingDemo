package com.landi.trainingdemo.pattern.absfactory;

/**
 * Created by guoj on 2019/8/23.
 */

public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Green::fill() method.");
    }
}
