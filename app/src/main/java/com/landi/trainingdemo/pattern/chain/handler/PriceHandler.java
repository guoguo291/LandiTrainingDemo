package com.landi.trainingdemo.pattern.chain.handler;

/**
 *  责任链模式：
 *  意图：避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求，将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。
 *  主要解决：职责链上的处理者负责处理请求，客户只需要将请求发送到职责链上即可，无须关心请求的处理细节和请求的传递，所以职责链将请求的发送者和请求的处理者解耦了。
 *  何时使用：在处理消息的时候以过滤很多道。
 *  如何解决：拦截的类都实现统一接口。
 *  优点：1.将请求者和接收者解耦2.增加新的请求处理类很方便3.简化了对象。使得对象不需要知道链的结构
 *        4.增强给对象指派职责的灵活性。通过改变链内的成员或者调动它们的次序，允许动态地新增或者删除责任
 *  缺点：效率较低，多个对象占用内存较多，影响性能
 *  开闭原则：对扩展开放，对变更关闭（需要增加业务处理层级时只需要新增一个handler，但是需要修改工程类方法，
 *  满足了开放，不满足关闭）
 * Created by guoj on 2019/8/12.
 */

public abstract class PriceHandler {
    //责任链中下一个传递者
    protected PriceHandler successor;

    abstract public void processDiscount(float discount);

    public void setSuccessor(PriceHandler successor){
        this.successor = successor;
    }
}
