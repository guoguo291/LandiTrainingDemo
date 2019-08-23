package com.landi.trainingdemo.pattern.adpter;

/**
 * Created by guoj on 2019/8/21.
 */

public class AdpterTest {
    public static void main(String[] args){
        TwoPlugIf twoPlug=new TwoPlugImpl();
        ThreePlugIf threePlug=new PlugAdapter(twoPlug);
        //类适配器只能为单一类做适配
//        ThreePlugIf threePlug=new PlugAdpterExtends();
        Tv tv=new Tv();
        tv.charge(threePlug);
    }
}
