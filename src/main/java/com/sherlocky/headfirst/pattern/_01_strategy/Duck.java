package com.sherlocky.headfirst.pattern._01_strategy;

import com.sherlocky.headfirst.pattern._01_strategy.behavior.FlyBehavior;
import com.sherlocky.headfirst.pattern._01_strategy.behavior.QuackBehavior;

/**
 * 鸭子超类
 * <p>鸭子现在将飞行和呱呱叫的动作“委托”（delegate）别人处理，而不是使用定义在Duck类（或子类）中的呱呱叫和飞行方法。</p>
 * @author: zhangcx
 * @date: 2018/12/22 12:51
 */
public abstract class Duck {
    // 行为变量呗声明为行为“接口”类型，实例变量在运行时会持有特定行为的引用
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    // 鸭子对象不亲自处理呱呱叫行为，而是委托给flyBehavior引用的对象处理
    public void performFly() {
        flyBehavior.fly();
    }
    public void performQuack() {
        quackBehavior.quack();
    }


    // 游泳
    public void swim() {
        System.out.println("鸭子会游泳");
    }
    // 外观
    abstract void display();
}
