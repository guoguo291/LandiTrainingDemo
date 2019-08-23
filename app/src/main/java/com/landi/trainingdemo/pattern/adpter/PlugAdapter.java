package com.landi.trainingdemo.pattern.adpter;

/**
 * 适配器模式：通过将一个接口转换成另外一个期望的接口，使得原本接口不兼容没法一起工作的两个类可以一起工作。
 * 作用：1.透明：通过适配器，客户端可以调用同一接口，对客户端来说是透明的。
 *       2.重用：复用了现有的类，解决了现有类和复用环境不一致的问题。
 *       3.低耦合：将目标类和需要适配的类解耦，通过引入一个适配器类复用现有适配者类，无需修改原有代码（满足开闭原则）
 * Created by guoj on 2019/8/21.
 */

/*适配器类，将一个二相插座适配成三项插座进行供电*/
public class PlugAdapter implements ThreePlugIf {
    TwoPlugIf twoPlug;
    //这里可以直接传入一个接口、抽象类、具体实现类都是可以的
    public PlugAdapter(TwoPlugIf twoPlug) {
        this.twoPlug = twoPlug;
    }

    @Override
    public void powerWithThree() {
        System.out.println("通过转换");
        twoPlug.powerWithTwo();
    }
}
