package com.landi.trainingdemo.pattern.proxy.dynamic;

import com.landi.trainingdemo.bean.Category;
import com.landi.trainingdemo.pattern.proxy.Image;
import com.landi.trainingdemo.pattern.proxy.ProxyImage;
import com.landi.trainingdemo.pattern.proxy.RealImage;

import java.lang.reflect.Proxy;

/**
 * Created by guoj on 2019/8/26.
 */

public class DynamicProxyPatternDemo {
    public static void main(String[] args) {

        //静态代理的缺陷：接口与代理类是1对1的（单一职责原则），有多个接口需要代理，就需要新建多个代理类，繁琐，类爆炸。
//        Color color=new ProxyColor();
//        Shape shape=new ProxyShape();
//        shape.draw("圆形");
//        color.fill("红色");

        Subject subject=new Subject();
        MyInvocationHandler myInvocationHandler=new MyInvocationHandler();
        Color color= (Color) myInvocationHandler.newProxyInstance(subject,new Class[]{Color.class,Shape.class});
        color.fill("白色");
        Shape shape= (Shape) myInvocationHandler.newProxyInstance(subject);
        shape.draw("椭圆形");
    }
}
