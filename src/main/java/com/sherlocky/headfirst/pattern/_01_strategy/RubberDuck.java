package com.sherlocky.headfirst.pattern._01_strategy;

/**
 * @author: zhangcx
 * @date: 2018/12/22 12:54
 */
public class RubberDuck extends Duck {

    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }

    @Override
    public void quack() {
        System.out.println("橡皮鸭只会吱吱叫");
    }
}
