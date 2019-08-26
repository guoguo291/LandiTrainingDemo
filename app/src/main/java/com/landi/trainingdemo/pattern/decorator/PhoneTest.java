package com.landi.trainingdemo.pattern.decorator;

/**
 * 装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。
 * 动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活，
 * 为了扩展一个类使用继承方式实现，由于继承为类引入静态特征，并且随着扩展功能的增多，子类会很膨胀。
 * 优点：装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。
 * 缺点：多层装饰比较复杂。
 * 使用场景： 1、扩展一个类的功能。 2、动态增加功能，动态撤销。
 * 满足开闭原则，需要重新扩展一个类的功能，只需要新增一个装饰器具体实现类就可以了。
 * Created by guoj on 2019/6/2
 */

public class PhoneTest {
    public static void main(String[] args){
        Phone phone=new Phone();
        phone.call();
        System.out.println("升级后---------------");
        VideoPhone videoPhone=new VideoPhone(new Phone());
        videoPhone.call();
    }
}
