package com.sherlocky.headfirst.pattern._03_decorator.decorator;

import com.sherlocky.headfirst.pattern._03_decorator.Beverage;

/**
 * 奶泡是调料的一种，继承自调料抽象类，是一个装饰者。
 * @author: zhangcx
 * @date: 2018/12/26 21:30
 */
public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
