package com.landi.trainingdemo.pattern.template;

/**
 * Created by guoj on 2019/8/23.
 */

public class TemplateTest {
    public static void main(String[] args){
        System.out.println("开始制作咖啡...");
        Beverage coffee=new Coffee();
        coffee.prepareBeverageTemplate();
        System.out.println("咖啡好了...");
        System.out.println("***************************");
        System.out.println("开始泡茶...");
        Beverage tea=new Tea();
        tea.prepareBeverageTemplate();
        System.out.println("茶泡好了...");
    }
}
