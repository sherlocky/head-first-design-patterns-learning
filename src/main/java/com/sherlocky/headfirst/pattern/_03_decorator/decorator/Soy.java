package com.sherlocky.headfirst.pattern._03_decorator.decorator;

import com.sherlocky.headfirst.pattern._03_decorator.Beverage;

/**
 * 豆浆是调料的一种，继承自调料抽象类，是一个装饰者。
 * <p>且要根据杯型大小不同定价</p>
 * @author: zhangcx
 * @date: 2018/12/26 21:30
 */
public class Soy extends CondimentDecorator {
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        if (beverage.getSize() == Size.TALL) {
            cost += .10;
        } else if (beverage.getSize() == Size.GRANDE) {
            cost += .15;
        } else if (beverage.getSize() == Size.VENTI) {
            cost += .20;
        }
        return cost;
    }
}
