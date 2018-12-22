package com.sherlocky.headfirst.pattern._01_strategy.behavior;

/**
 * 让飞行的动作被其他对象复用，因为这些行为已经与鸭子类无关了。
 * <p>而我们可以新增一些行为，不会影响到既有的行为类，也不会影响“使用”到飞行行为的鸭子类，这样一来有了继承的复用好处，却没有继承所带来的包袱。</p>
 * @author: zhangcx
 * @date: 2018/12/22 13:09
 */
public interface FlyBehavior {

    void fly();
}
