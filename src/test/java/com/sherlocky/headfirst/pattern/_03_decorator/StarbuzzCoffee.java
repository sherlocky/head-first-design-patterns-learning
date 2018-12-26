package com.sherlocky.headfirst.pattern._03_decorator;

import com.sherlocky.headfirst.pattern._03_decorator.decorator.Mocha;
import com.sherlocky.headfirst.pattern._03_decorator.decorator.Soy;
import com.sherlocky.headfirst.pattern._03_decorator.decorator.Whip;

/**
 * 星巴兹咖啡测试类
 * @author: zhangcx
 * @date: 2018/12/26 21:41
 */
public class StarbuzzCoffee {

    public static void main(String[] args) {
        // 制造一杯浓缩咖啡，不需要调料，打印描述和价格
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + ": $" + beverage.cost());

        // 制造一杯深烘焙咖啡，双倍摩卡+奶泡，打印描述和价格
        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + ": $" + beverage2.cost());

        // 制造一杯黑咖啡，加奶泡、摩卡、豆浆，打印描述和价格
        Beverage beverage3 = new HouseBlend();
        beverage3 = new Whip(new Mocha(new Soy(beverage3)));
        System.out.println(beverage3.getDescription() + ": $" + beverage3.cost());

        // 制造一【中杯】黑咖啡，加奶泡、摩卡、豆浆，打印描述和价格
        Beverage beverage4 = new HouseBlend();
        beverage4.setSize(Beverage.Size.GRANDE);
        beverage4 = new Whip(new Mocha(new Soy(beverage4)));
        System.out.println(beverage4.getDescription() + ": $" + beverage4.cost());
    }
}
