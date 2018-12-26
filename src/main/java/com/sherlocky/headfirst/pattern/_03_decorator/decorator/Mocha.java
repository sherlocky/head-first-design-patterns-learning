package com.sherlocky.headfirst.pattern._03_decorator.decorator;

import com.sherlocky.headfirst.pattern._03_decorator.Beverage;

/**
 * 摩卡是调料的一种，继承自调料抽象类，是一个装饰者。
 * @author: zhangcx
 * @date: 2018/12/26 21:30
 */
public class Mocha extends CondimentDecorator {
    // 通过构造器将饮料记录在实例变量中
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        // 要计算Mocha的价格，首先把调用委托给被装饰对象，以计算价格，然后再加上Mocha的价格，得到最后结果。
        return 0.20 + beverage.cost();
    }
}
