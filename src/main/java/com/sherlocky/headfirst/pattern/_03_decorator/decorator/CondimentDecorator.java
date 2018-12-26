package com.sherlocky.headfirst.pattern._03_decorator.decorator;

import com.sherlocky.headfirst.pattern._03_decorator.Beverage;

/**
 * 抽象调料类——亦即本例中装饰者类
 * <p>CondimentDecorator 应该继承 Beverage，此处继承是为了有正确的类型(为了能够取代Beverage)，而不是继承他的行为。</p>
 * @author: zhangcx
 * @date: 2018/12/26 21:19
 */
public abstract class CondimentDecorator extends Beverage {
    // 用一个实例变量记录饮料（被装饰者）
    public Beverage beverage;

    // 所有调料装饰者都必须重写getDescription()方法，为了能详细的描述出调料
    @Override
    public abstract String getDescription();

    public Size getSize() {
        return beverage.getSize();
    }
}
