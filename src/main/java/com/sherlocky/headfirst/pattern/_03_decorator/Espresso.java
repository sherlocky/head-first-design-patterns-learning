package com.sherlocky.headfirst.pattern._03_decorator;

/**
 * 浓缩咖啡（一种饮料），继承自饮料抽象类
 * @author: zhangcx
 * @date: 2018/12/26 21:25
 */
public class Espresso extends Beverage {
    // 构造器中设置饮料的描述
    public Espresso() {
        super.description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
