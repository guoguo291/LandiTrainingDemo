package com.landi.trainingdemo.pattern.decorator;

import com.landi.trainingdemo.pattern.decorator.Communication;

/**
 * Created by guoj on 2019/6/2
 */

public class Phone implements Communication {
    @Override
    public void call() {
        System.out.println("打电话");
    }
}
