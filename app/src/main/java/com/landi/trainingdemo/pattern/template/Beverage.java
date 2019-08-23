package com.landi.trainingdemo.pattern.template;

/**
 * 模板方法：一个抽象类公开定义了执行它的方法的方式/模板。它的子类可以按需要重写方法实现，
 * 但调用将以抽象类中定义的方式进行。
 * 目的：定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。
 *       模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 * 优点： 1、封装不变部分，扩展可变部分。 2、提取公共代码，便于维护。 3、行为由父类控制，子类实现。
 * 缺点：每一个不同的实现都需要一个子类来实现，导致类的个数增加，使得系统更加庞大。
 * Created by guoj on 2019/8/23.
 */

abstract public class Beverage {
    //模板方法不允许子类复写定义成final
    public final void prepareBeverageTemplate() {
        //制作饮品1热水2冲泡方式3倒入杯中4加入调味料料
        boilWater();
        brew();
        pourInCup();
        if (isCustomWantCondiment()) {
            addCondiment();
        }
    }
    //留给子类灵活实现
    protected abstract void brew();

    abstract protected void addCondiment();
    //钩子函数
    protected boolean isCustomWantCondiment() {
        return true;
    }

    private void pourInCup() {
        System.out.println("倒入杯中");
    }

    private void boilWater() {
        System.out.println("热水");
    }


}
