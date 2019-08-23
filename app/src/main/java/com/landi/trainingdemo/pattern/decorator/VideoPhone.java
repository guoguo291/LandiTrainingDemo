package com.landi.trainingdemo.pattern.decorator;

import com.landi.trainingdemo.pattern.decorator.Communication;
import com.landi.trainingdemo.pattern.decorator.CommunicationDecorator;

/**
 * Created by guoj on 2019/6/2
 */

public class VideoPhone extends CommunicationDecorator {
    public VideoPhone(Communication communication) {
        super(communication);
    }

    @Override
    public void call() {
        System.out.println("增加了视屏功能");
        super.call();
    }
}
