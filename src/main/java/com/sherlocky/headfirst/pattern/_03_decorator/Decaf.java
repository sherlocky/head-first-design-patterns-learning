package com.sherlocky.headfirst.pattern._03_decorator;

/**
 * 无咖啡因咖啡（一种饮料），继承自饮料抽象类
 * @author: zhangcx
 * @date: 2018/12/26 21:25
 */
public class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf Coffee";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}

