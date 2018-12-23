package com.sherlocky.headfirst.pattern._01_strategy;

import com.sherlocky.headfirst.pattern._01_strategy.behavior.FlyRocketPowered;

/**
 * 迷你鸭子模拟器，测试以鸭子为例的策略模式
 * @author: zhangcx
 * @date: 2018/12/23 8:37
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        // 构造器内默认了一个 FlyBehavior
        mallard.performFly();

        // 覆盖设置一个 FlyBehavior
        mallard.setFlyBehavior(new FlyRocketPowered());
        mallard.performFly();
        // 在运行时想要改变鸭子的行为，只需调用鸭子的setter方法就可以
    }
}
