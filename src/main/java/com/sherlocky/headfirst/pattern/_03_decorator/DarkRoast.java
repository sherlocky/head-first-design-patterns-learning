package com.sherlocky.headfirst.pattern._03_decorator;

/**
 * 深烘焙咖啡（一种饮料），继承自饮料抽象类
 * @author: zhangcx
 * @date: 2018/12/26 21:25
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return .99;
    }
}

