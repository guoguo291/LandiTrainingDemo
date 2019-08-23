package com.landi.trainingdemo.pattern.decorator;

import com.landi.trainingdemo.pattern.decorator.Communication;

/**
 * Created by guoj on 2019/6/2
 */

public abstract class CommunicationDecorator implements Communication {
    public Communication communication;

    public CommunicationDecorator(Communication communication) {
        this.communication = communication;
    }

    @Override
    public void call() {
        communication.call();
    }
}
