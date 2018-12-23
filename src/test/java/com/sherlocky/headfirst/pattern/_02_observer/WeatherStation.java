package com.sherlocky.headfirst.pattern._02_observer;

/**
 * @author: zhangcx
 * @date: 2018/12/23 15:44
 */
public class WeatherStation {

    public static void main(String[] args) {
        // 先建立一个WeatherDataSubject对象
        WeatherDataSubject wd = new WeatherDataSubject();

        CurrentConditionsDisplay d = new CurrentConditionsDisplay(wd);
        // 还可以实现其他各种各样的Display

        // 模拟新的气象测量数据（有更新）
        wd.setMeasurements(27, 38, 1340);
    }
}
