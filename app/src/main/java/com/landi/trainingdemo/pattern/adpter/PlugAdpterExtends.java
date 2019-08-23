package com.landi.trainingdemo.pattern.adpter;

/**
 * Created by guoj on 2019/8/21.
 * 类适配器：只能给一个指定的类进行适配
 */

public class PlugAdpterExtends extends TwoPlugImpl implements ThreePlugIf{
    @Override
    public void powerWithThree() {
        this.powerWithTwo();
    }
}
