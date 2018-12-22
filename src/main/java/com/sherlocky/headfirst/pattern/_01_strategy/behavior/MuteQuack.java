package com.sherlocky.headfirst.pattern._01_strategy.behavior;

/**
 * @author: zhangcx
 * @date: 2018/12/22 13:27
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不会叫");
    }
}
