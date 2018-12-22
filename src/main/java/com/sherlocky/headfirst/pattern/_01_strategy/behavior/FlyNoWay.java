package com.sherlocky.headfirst.pattern._01_strategy.behavior;

/**
 * @author: zhangcx
 * @date: 2018/12/22 13:27
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}
