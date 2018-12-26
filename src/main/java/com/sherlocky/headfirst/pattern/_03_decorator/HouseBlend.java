package com.sherlocky.headfirst.pattern._03_decorator;

/**
 * 黑(混合)咖啡（一种饮料），继承自饮料抽象类
 * @author: zhangcx
 * @date: 2018/12/26 21:27
 */
public class HouseBlend extends Beverage {
    // 构造器中设置饮料的描述
    public HouseBlend() {
        super.description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
