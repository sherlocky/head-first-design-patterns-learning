package com.sherlocky.headfirst.pattern._01_strategy.behavior;

/**
 * @author: zhangcx
 * @date: 2018/12/23 8:42
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("火箭动力飞行~~");
    }
}
