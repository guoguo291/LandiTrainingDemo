package com.landi.trainingdemo.pattern.chain.handler;


/**
 * Created by guoj on 2019/8/12.
 */

public class Ceo extends PriceHandler {

    @Override
    public void processDiscount(float discount) {
        if (discount<=0.3){
            System.out.format("%s批准了折扣:%.2f%n",this.getClass().getName(),discount);
        }else {
            System.out.format("%s拒绝了折扣:%.2f%n",this.getClass().getName(),discount);
        }
    }
}
