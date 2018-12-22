package com.sherlocky.headfirst.pattern._01_strategy;

import com.sherlocky.headfirst.pattern._01_strategy.behavior.FlyWithWings;
import com.sherlocky.headfirst.pattern._01_strategy.behavior.Quack;

/**
 * @author: zhangcx
 * @date: 2018/12/22 12:54
 */
public class MallardDuck extends Duck {

    // 当MallardDuck实例化时，他的构造器会把继承来的quckBehavior实例变量初始化成Quack类型的新实例（Quack是QuackBehavior的具体实现类）
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
        // 此处，初始化实例变量的做法不够弹性，后续学习更多模式之后可以优化此处
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
