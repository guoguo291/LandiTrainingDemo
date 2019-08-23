package com.landi.trainingdemo.pattern.adpter;

/**
 * Created by guoj on 2019/8/21.
 */

public class TwoPlugImpl implements TwoPlugIf {

    @Override
    public void powerWithTwo() {
        System.out.print("使用二相电流供电");
    }
}
