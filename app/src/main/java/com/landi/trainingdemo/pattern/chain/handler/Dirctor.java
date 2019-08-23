package com.landi.trainingdemo.pattern.chain.handler;

import com.landi.trainingdemo.pattern.chain.handler.PriceHandler;

/**
 * Created by guoj on 2019/8/21.
 */

public class Dirctor extends PriceHandler {
    @Override
    public void processDiscount(float discount) {
        if (discount<=0.2){
            System.out.format("%s批准了折扣:%.2f%n",this.getClass().getName(),discount);
        }else {
            successor.processDiscount(discount);
        }
    }
}
