package com.sherlocky.headfirst.pattern._08_facade;

/**
 * 引擎/发动机类 -- 子系统角色
 * @author: zhangcx
 * @date: 2019/9/8 18:15
 */
public class CarEngine {
    public void startEngine() {
        System.out.println("发动引擎~");
    }

    public void turnOffEngine() {
        System.out.println("引擎熄火~");
    }
}
