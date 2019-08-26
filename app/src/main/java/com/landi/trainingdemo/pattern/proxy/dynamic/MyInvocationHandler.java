package com.landi.trainingdemo.pattern.proxy.dynamic;

import com.landi.trainingdemo.pattern.proxy.Image;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by guoj on 2019/8/26.
 */

public class MyInvocationHandler implements InvocationHandler{
    Object targetObject;

    //绑定关系，也就是关联到哪个接口（与具体的实现类绑定）的哪些方法将被调用时，执行invoke方法。
    public Object newProxyInstance(Object targetObject, Class<?>[] interfaces){
        this.targetObject=targetObject;
        //该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
        //第一个参数指定产生代理对象的类加载器，需要将其指定为和目标对象同一个类加载器
        //第二个参数要实现和目标对象一样的接口，所以只需要拿到目标对象的实现接口
        //第三个参数表明这些被拦截的方法在被拦截时需要执行哪个InvocationHandler的invoke方法
        //根据传入的目标返回一个代理对象
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                interfaces,this);
    }
    public Object newProxyInstance(Object targetObject){
        this.targetObject=targetObject;

        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),this);
    }

    /**
     * @param proxy    代理类
     * @param method    正在调用的方法
     * @param args      方法的参数
     * @return
     * @throws Throwable
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("draw")){
            System.out.println("代理记录draw的时间："+System.currentTimeMillis());
            method.invoke(targetObject, args);
        }else if(method.getName().equals("fill")){
            System.out.println("代理记录fill的时间："+System.currentTimeMillis());
            method.invoke(targetObject, args);
        }
        return null;
    }
}
