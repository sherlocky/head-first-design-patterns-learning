package com.sherlocky.headfirst.pattern._01_strategy.behavior;

/**
 * @author: zhangcx
 * @date: 2018/12/22 13:25
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("用翅膀飞行");
    }
}
