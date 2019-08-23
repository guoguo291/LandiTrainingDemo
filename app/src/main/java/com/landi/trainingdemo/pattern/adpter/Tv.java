package com.landi.trainingdemo.pattern.adpter;

/**
 * Created by guoj on 2019/8/21.
 */

public class Tv {



    //通电
    public void charge(ThreePlugIf threePlugIf){
        threePlugIf.powerWithThree();
    }
}
