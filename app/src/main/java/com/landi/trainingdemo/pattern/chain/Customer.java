package com.landi.trainingdemo.pattern.chain;

import com.landi.trainingdemo.pattern.chain.handler.PriceHandler;
import com.landi.trainingdemo.pattern.chain.handler.PriceHandlerFactory;

import java.util.Random;

/**
 *
 * Created by guoj on 2019/8/12.
 */

public class Customer {
    //只给与一个请求类型，将请求者和接受者解耦
    void requestDiscount(PriceHandler priceHandler, float discount) {
        priceHandler.processDiscount(discount);
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            customer.requestDiscount(PriceHandlerFactory.createPriceHandler(), random.nextFloat());
        }
    }
}
