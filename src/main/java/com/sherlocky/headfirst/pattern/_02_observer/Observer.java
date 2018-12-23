package com.sherlocky.headfirst.pattern._02_observer;

/**
 * @author: zhangcx
 * @date: 2018/12/23 15:03
 */
public interface Observer {

    // 当气象观测值改变时，主题会把这些状态值当做方法的参数，传送给观察者。
    // 所有的观察者都必须实现update()方法，以实现观察者接口，
    public void update(float temperature, float humidity, float pressure);
}
