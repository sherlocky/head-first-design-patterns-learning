package com.sherlocky.headfirst.pattern._08_facade;

/**
 * 汽车电源类 -- 子系统角色
 * @author: zhangcx
 * @date: 2019/9/8 20:46
 */
public class CarPower {
    public void turnOnPower() {
        System.out.println("全车通电~");
    }

    public void turnOffPower() {
        System.out.println("关闭电源~");
    }
}
