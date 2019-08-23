package com.landi.trainingdemo.pattern.chain.handler;

/**
 * Created by guoj on 2019/8/21.
 */

public class PriceHandlerFactory {

    public static PriceHandler createPriceHandler(){
        Saler saler=new Saler();
        Manager manager=new Manager();
        Dirctor dirctor=new Dirctor();
        Ceo ceo=new Ceo();
        saler.setSuccessor(manager);
        manager.setSuccessor(dirctor);
        dirctor.setSuccessor(ceo);
        return saler;
    }
}
