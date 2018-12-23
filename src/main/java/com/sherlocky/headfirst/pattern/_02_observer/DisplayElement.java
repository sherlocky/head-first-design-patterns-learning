package com.sherlocky.headfirst.pattern._02_observer;

/**
 * @author: zhangcx
 * @date: 2018/12/23 15:08
 */
public interface DisplayElement {
    // 只包含一个方法，当布告板需要显示时调用此方法
    public void display();
}
